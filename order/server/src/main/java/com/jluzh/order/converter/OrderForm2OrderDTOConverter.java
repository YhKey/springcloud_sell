package com.jluzh.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jluzh.order.dataobject.OrderDetail;
import com.jluzh.order.dto.OrderDTO;
import com.jluzh.order.enums.ResultEnum;
import com.jluzh.order.exception.OrderException;
import com.jluzh.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yanghongkun
 * @description: orderForm -> orderDTO
 * @date: 2020/08/28
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        //items 使用Gson工具转换
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Gson gson = new Gson();
        try {
            //参数格式不对可能转换出错
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("【json转换】错误，msg={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
