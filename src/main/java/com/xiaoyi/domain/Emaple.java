package com.xiaoyi.domain;

/**
 * @author ������
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
    System.out.println("�������޲ι�����");
  }

  public Emaple(Integer id, String name) {
    this.id = id;
    this.name = name;
    System.out.println("�������вι�����");
  }

  @Override
  public String toString() {
    return "Emaple{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  private void hello(String name) {
    System.out.println(name);
  }
}
