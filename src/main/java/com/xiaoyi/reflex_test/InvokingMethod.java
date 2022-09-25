package com.xiaoyi.reflex_test;

import com.xiaoyi.domain.Emaple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 王艺翔
 * @description InvokingMethod
 * @date 2022/9/25 12:54
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
public class InvokingMethod {
  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
          InstantiationException, IllegalAccessException {
    // 创建Class对象
    Class<?> aClass = Class.forName("com.xiaoyi.domain.Emaple");
    // 创建Emaple实例
    Emaple emaple = (Emaple) aClass.getDeclaredConstructor().newInstance();
    // 获取方法
    Method hello = aClass.getDeclaredMethod("hello", String.class);
    // 设置权限
    hello.setAccessible(true);
    // 调用方法
    hello.invoke(emaple, "jet");
  }
}
