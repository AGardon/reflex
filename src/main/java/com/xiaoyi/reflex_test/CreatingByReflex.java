package com.xiaoyi.reflex_test;

import com.xiaoyi.domain.Emaple;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 王艺翔
 * @description CreateObjectByReflex
 * @date 2022/9/25 11:53
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
public class CreatingByReflex {

  public static void main(String[] args) {}

  /**
   * 创建Class对象的方式
   *
   * @throws ClassNotFoundException
   */
  @Test
  public void test2() throws ClassNotFoundException {
    Class<Emaple> aClass1 = Emaple.class;
    Class<?> aClass = Class.forName("com.xiaoyi.domain.Emaple");
  }

  /**
   * 通过构造器
   *
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   */
  @Test
  public void test1()
      throws InstantiationException, IllegalAccessException, NoSuchMethodException,
          InvocationTargetException {
    Emaple emaple1 = Emaple.class.getDeclaredConstructor().newInstance();
    Emaple emaple2 =
        Emaple.class.getDeclaredConstructor(Integer.class, String.class).newInstance(1, "hello");
  }
}
