package example;


import org.junit.Test;

public class Fibonaqi {


  @Test
  public void test() {
    Fibonaqi fibonaqi = new Fibonaqi();
    int count = fibonaqi.algo(6);
    System.out.print(count);
  }

  public int algo(int size) {

    if (size < 2) {
      return size == 0 ? 0 : 1;
    }
    return algo(size - 2) + algo(size - 1);

  }

  public static void main(String[] args) {

    int[] a = new int[40];
    a[0] = 0;
    a[1] = 1;

    for (int i = 2; i < 40; i++) {

      a[i] = a[i - 1] + a[i - 2];
      System.out.println(a[i]);

    }
  }


}
