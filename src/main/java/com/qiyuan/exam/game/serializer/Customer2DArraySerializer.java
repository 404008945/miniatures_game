package com.qiyuan.exam.game.serializer;

/**
 * @author liuxishan
 * @date 2024/7/5
 */

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class Customer2DArraySerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
            return;
        }

        int[][] array = (int[][]) object;
        out.write('[');

        boolean first2D = true;
        for (int j = 0; j < array.length; j++) {
            if (!first2D) {
                out.write(',');
            } else {
                first2D = false;
            }
            out.write('[');
            for (int k = 0; k < array[j].length; k++) {
                if (k != 0) {
                    out.write(',');
                }
                out.writeInt(array[j][k]);
            }
            out.write(']');
        }

        out.write(']');
    }
}