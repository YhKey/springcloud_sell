package com.jluzh.order.service.impl;

import com.jluzh.order.dataobject.OrderDetail;
import com.jluzh.order.dataobject.OrderMaster;
import com.jluzh.order.dto.OrderDTO;
import com.jluzh.order.enums.OrderStatusEnum;
import com.jluzh.order.enums.PayStatusEnum;
import com.jluzh.order.repository.OrderDetailRepository;
import com.jluzh.order.repository.OrderMasterRepository;
import com.jluzh.order.service.OrderService;
import com.jluzh.order.utils.KeyUtil;
import com.jluzh.product.client.ProductClient;
import com.jluzh.product.common.DecreaseStockInput;
import com.jluzh.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: yanghongkun
 * @description:
 * @date: 2020/08/27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        //2.根据productId查询商品信息,调用商品服务，但没有暴露接口供调用
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        //3.计算总金额，入参有用户信息，以及商品id和数量，很多信息都需要查询
        BigDecimal orderAmout = new BigDecimal(0);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            for (ProductInfoOutput productInfo : productInfoList){
                if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    //单价 * 数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        //4.扣库存
        List<DecreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        productClient.decreaseStock(cartDTOList);

        //主订单入库
        OrderMaster orderMaster = new OrderMaster();
        //生成orderId,再拷贝
        orderDTO.setOrderId(orderId);
        //用户信息
        BeanUtils.copyProperties(orderDTO,orderMaster);
        //订单总金额
        orderMaster.setOrderAmount(orderAmout);
        //订单状态
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        //支付状态
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

}
