package com.example.demo.sort;

import com.alibaba.fastjson.JSON;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * redis实现自定义id自增
 */
@Service
public class IdIncrement {

    @Autowired
    private RedisUtil redisUtil;

    public Long getIncrementId(String prefix) {
        String key = "DEMO_ORDER_ID_" + prefix;
        String orderId = null;
        try {
            if (redisUtil.expire(key, -1)) {
                //利用redis的increment实现自定义id自增
                Long incr = redisUtil.incr(key, 1);
                //往前补6位
                orderId = prefix + String.format("%1$06d", incr);
            } else {
                redisUtil.set(key, prefix, -1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Long.valueOf(orderId);
    }

    public String getIncrementIdStr(String prefix) {
        String key = "DEMO_ORDER_ID_" + prefix;
        String orderId = null;
        try {
            if (redisUtil.expire(key, -1)) {
                //利用redis的increment实现自定义id自增
                Long incr = redisUtil.incr(key, 1);
                //往前补6位
                orderId = prefix + String.format("%1$06d", incr);
            } else {
                redisUtil.set(key, prefix, -1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }


    //用java的方式（双重检查锁）
    public void getIncrementIdStrV2() {
        String key = "DEMO_ORDER_ID_";
        try {
            String oldId = JSON.toJSONString(redisUtil.get(key));
            if ("null".equals(oldId)) {
                synchronized (this) {
                    if ("null".equals(oldId)) {
                        redisUtil.set(key, 100, -1);
                    } else {
                        Integer num = new Integer(oldId);
                        redisUtil.set(key, num + 1, -1);
                    }
                }
            } else {
                Integer num = new Integer(oldId);
                redisUtil.set(key, num + 1, -1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
