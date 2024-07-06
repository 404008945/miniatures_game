package com.qiyuan.exam.game.util;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qiyuan.exam.game.serializer.Customer2DArraySerializer;
import com.qiyuan.exam.game.serializer.CustomerArraySerializer;

/**
 * @author liuxishan
 * @date 2024/7/6
 */
public class JsonUtil {
    private  static  SerializeConfig config = new SerializeConfig();

    static {
        config.put(int[][].class, new Customer2DArraySerializer());
        config.put(int[].class, new CustomerArraySerializer());
    }

    public static String toJson(Object obj) {
        return com.alibaba.fastjson.JSON.toJSONString(obj, config, SerializerFeature.PrettyFormat);
    }
}
