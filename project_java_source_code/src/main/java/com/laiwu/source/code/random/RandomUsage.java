package com.laiwu.source.code.random;

public class RandomUsage {

  public static final String[] data = { "tom", "peter", "lily", "jim", "han" };

  public static void main(String[] args) {
    for (int i = 0; i < 6; i++) {
      int index = new java.util.Random().nextInt(data.length);
      System.out.println(data[index]);
    }
  }

}
