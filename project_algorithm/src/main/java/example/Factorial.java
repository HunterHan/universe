package example;

import org.junit.Test;

/**
 * 阶乘算法 - 递归实现
 */
public class Factorial {

  public int factorial(int number) {
    if (number <= 1)
      return 1;
    return number * factorial(number - 1);
  }

  @Test
  public void test() {
    int result = new Factorial().factorial(4);
    System.out.println(result);
  }
}
