package com.xiaoyi.reflex_test;

import com.xiaoyi.domain.Emaple;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 王艺翔
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
    // 创建Class对象
    Class<?> clazz = Class.forName("com.xiaoyi.domain.Emaple");
    // 通过构造器创建Emaple实例
    Emaple emaple = (Emaple) clazz.getConstructor().newInstance();
    // 获取成员属性
    Field id = clazz.getDeclaredField("id");
    // 设置访问权限
    id.setAccessible(true);
    // 赋值
    id.set(emaple, 12);
    System.out.println(emaple.toString());
  }
}
