package example;

import java.util.Arrays;

public class KMP {


  public static int kmp(String dest, String patt, Integer[] next) {//str文本串  dest 模式串
    for (int i = 0, j = 0; i < dest.length(); i++) {
      while (j > 0 && dest.charAt(i) != patt.charAt(j)) {
        j = next[j - 1];
      }
      if (dest.charAt(i) == patt.charAt(j)) {
        j++;
      }
      if (j == patt.length()) {
        return i - j + 1;
      }
    }
    return 0;
  }

  /**
   * next数组的计算主要跟模式串有关，与文本串并没有关系，因为，模式串前后公共最长子序列。这样才会让我们跳过大量的重复计算
   * next数组的主要实现方法有很多，就是要找到前后最长公共子序列的长度
   *
   * @param patt
   * @return
   */
  public static Integer[] getKMPNext(String patt) {
    Integer[] next = new Integer[patt.length()];
    next[0] = 0;
    for (int i = 1, j = 0; i < patt.length(); i++) {
      while (j > 0 && patt.charAt(j) != patt.charAt(i)) {
        j = next[j - 1];
      }
      if (patt.charAt(i) == patt.charAt(j)) {
        j++;
      }
      next[i] = j;
    }
    return next;
  }

  public static void main(String[] args) {
    String patt = "ababa";
    String dest = "sdfgasdbababa";
    Integer[] next = getKMPNext(patt);
    int res = kmp(dest, patt, next);
    System.out.println(res);

    System.out.println(Arrays.toString(next));

    Arrays.asList(next).stream().forEach(s -> System.out.println(s));//java8

    System.out.println(Arrays.asList(next));

    System.out.println(next.length);
  }
}
