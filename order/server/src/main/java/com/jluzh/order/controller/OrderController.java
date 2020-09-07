package com.jluzh.order.controller;

import com.jluzh.order.VO.ResultVO;
import com.jluzh.order.converter.OrderForm2OrderDTOConverter;
import com.jluzh.order.dto.OrderDTO;
import com.jluzh.order.enums.ResultEnum;
import com.jluzh.order.exception.OrderException;
import com.jluzh.order.form.OrderForm;
import com.jluzh.order.service.OrderService;
import com.jluzh.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yanghongkun
 * @description:
 * @date: 2020/08/27
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1.参数校验
     * 2.根据productId查询商品信息
     *      注：不能从前端将商品的信息（价格）传到后台，直接用这个信息做处理的话很危险，中途可能被篡改，为了安全只传productId 和数量
     *      查询：微服务的架构，两个服务可能是不同的数据库 ，假如商品信息不在自己的库中，这时需要调用商品服务来查询
     * 3.做一系列判断，数量够不够之类，最后计算总金额
     * 4.扣库存（调用商品服务）
     * 5.订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult
                       ){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确 , orderForm = {}",orderForm);
            throw  new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        //orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        //判断购物车转换后是否为空，form接收时只是校验字符串是否为空，判断点不同
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }
}
