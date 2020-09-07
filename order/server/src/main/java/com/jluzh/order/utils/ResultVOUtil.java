package com.jluzh.order.utils;


import com.jluzh.order.VO.ResultVO;

/**
 * @author: yanghongkun
 * @description:
 * @date: 2020/08/25
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return  success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO =new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}
