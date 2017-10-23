package example;

import org.junit.Test;

public class BruteForce {

  public boolean bf(String des, String patt) {

    int pattStartIndex = 0;

    for (int i = 0; i < des.length(); i++) {

      for (int j = pattStartIndex; j < patt.length(); j++) {

        if (des.charAt(i) != patt.charAt(j)) {
          pattStartIndex = 0;
          break;

        } else {

          if (pattStartIndex == patt.length() - 1) {
            return true;

          }

          pattStartIndex++;
          break;

        }

      }

    }

    return false;

  }

  @Test
  public void test() {
    boolean flag = new BruteForce().bf("ababcababa", "ababa");
    System.out.println(flag);
  }
}
