package com.xiaoyi.reflex_test;

import com.xiaoyi.domain.Emaple;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ������
 * @description AssignForFlied
 * @date 2022/9/25 12:55
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
public class AssignForFlied {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException,
          NoSuchMethodException, InvocationTargetException, InstantiationException {
    // ����Class����
    Class<?> clazz = Class.forName("com.xiaoyi.domain.Emaple");
    // ͨ������������Emapleʵ��
    Emaple emaple = (Emaple) clazz.getConstructor().newInstance();
    // ��ȡ��Ա����
    Field id = clazz.getDeclaredField("id");
    // ���÷���Ȩ��
    id.setAccessible(true);
    // ��ֵ
    id.set(emaple, 12);
    System.out.println(emaple.toString());
  }
}
