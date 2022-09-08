package com.cx.lib_base.utils;

import androidx.annotation.NonNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
public class Utils {
    public static <T> Class<T> getInterfaceClass(@NonNull Class<T> clazz, int typeIndex) {
        Type type = clazz.getGenericSuperclass();
        if (type == null) {
            return null;
        } else {
            while(!(type instanceof ParameterizedType) && type instanceof Class) {
                type = ((Class)type).getGenericSuperclass();
            }

            return !(type instanceof ParameterizedType) ? null : (Class)((ParameterizedType)type).getActualTypeArguments()[typeIndex];
        }
    }
}
