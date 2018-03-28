package com.laiwu.source.code.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
  /**
   * 加    add
   * 减    subtract
   * 乘    multiply
   * 除    divide
   */

  void add() {
      // BigDecimal(String)
      BigDecimal num1 = new BigDecimal("1");
      BigDecimal num2 = new BigDecimal("2");

      BigDecimal result = num1.add(num2);
      System.out.println(result);

      // BigDecimal(double)
      BigDecimal num3 = new BigDecimal(2.22);
      double dou = 0.22;
      BigDecimal num4 = new BigDecimal(dou);
      System.out.println(num3);
      System.out.println(num4);

      // 余数
      BigDecimal remainder = num1.remainder(num2);
      System.out.println(remainder);

      // 相反数
      BigDecimal negate = num2.negate();
      System.out.println(negate);

      // 比较
      int compareTo = num2.compareTo(num1);
      System.out.println(compareTo);

      BigDecimal num5 = new BigDecimal("2.0");
      BigDecimal num6 = new BigDecimal("2.00");

      System.out.println(num5.compareTo(num6));


  }

  public static void main(String[] args) {
      BigDecimalTest test = new BigDecimalTest();
      test.add();
  }

}
