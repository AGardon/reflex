package com.xiaoyi.reflex_test;

import com.xiaoyi.domain.Emaple;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ������
 * @description CreateObjectByReflex
 * @date 2022/9/25 11:53
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
public class CreatingByReflex {

  public static void main(String[] args) {}

  /**
   * ����Class����ķ�ʽ
   *
   * @throws ClassNotFoundException
   */
  @Test
  public void test2() throws ClassNotFoundException {
    Class<Emaple> aClass1 = Emaple.class;
    Class<?> aClass = Class.forName("com.xiaoyi.domain.Emaple");
  }

  /**
   * ͨ��������
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
