package com.xiaoyi.domain;

/**
 * @author 王艺翔
 * @description Emaple
 * @date 2022/9/25 11:56
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
public class Emaple {
  private Integer id;
  private String name;

  public Emaple() {
    System.out.println("调用了无参构造器");
  }

  public Emaple(Integer id, String name) {
    this.id = id;
    this.name = name;
    System.out.println("调用了有参构造器");
  }

  @Override
  public String toString() {
    return "Emaple{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  private void hello(String name) {
    System.out.println(name);
  }
}
