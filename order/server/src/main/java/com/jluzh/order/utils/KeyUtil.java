package com.jluzh.order.utils;

import java.util.Random;

/**
 * @author: yanghongkun
 * @description: 生成唯一主键
 * @date: 2020/08/27
 */
public class KeyUtil {

    /**
     * 时间 + 随机数
     *    注意：简易方法，如果并发大、项目多的话，不能保证唯一
     *    公式层面的话，需要专门写一个项目，供各个服务方调用，保证唯一
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 1000000;//生成6位随机数+6位
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
