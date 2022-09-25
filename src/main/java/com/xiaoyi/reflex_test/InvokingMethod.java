package com.xiaoyi.reflex_test;

import com.xiaoyi.domain.Emaple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ������
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
    // ����Class����
    Class<?> aClass = Class.forName("com.xiaoyi.domain.Emaple");
    // ����Emapleʵ��
    Emaple emaple = (Emaple) aClass.getDeclaredConstructor().newInstance();
    // ��ȡ����
    Method hello = aClass.getDeclaredMethod("hello", String.class);
    // ����Ȩ��
    hello.setAccessible(true);
    // ���÷���
    hello.invoke(emaple, "jet");
  }
}
