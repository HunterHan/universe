package com.laiwu.source.code.java.lang;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

public class MyDecimal {
  public static void main(String[] args) {

    Object A = 10;
    Object B = 30;

    BigDecimal decimalA = new BigDecimal(String.valueOf(A));
    BigDecimal decimalB = new BigDecimal(String.valueOf(B));

    BigDecimal result = decimalA.divide(decimalB, 10, ROUND_HALF_DOWN);

    System.out.println(result);
  }
}
