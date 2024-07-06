package com.qiyuan.exam.game.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author liuxishan
 * @date 2024/7/6
 */
public class CustomerArraySerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
            return;
        }

        int[] array = (int[]) object;
        out.write('[');
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                out.write(',');
            }
            out.writeInt(array[i]);
        }
        out.write(']');
    }

}
