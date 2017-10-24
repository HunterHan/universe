package example;

import org.junit.Test;

public class BruteForce {

  /**
   * @param ts 待匹配字符串
   * @param ps 模式字符串
   * @return 带匹配字符串中复合模式字符串的索引，-1表示不匹配
   */
  public int bf(String ts, String ps) {

    char[] t = ts.toCharArray();//主串
    char[] p = ps.toCharArray();//模式串
    int i = 0;//主串
    int j = 0;//模式串
    while (i < t.length && j < p.length) {
      if (t[i] == p[j]) {//当两个字符相同，就继续比较下一个
        i++;
        j++;
      } else {
        i = i - j + 1;//不匹配则i后退
        j = 0;//j归０
      }
    }
    if (j == p.length) {
      return i - j;//匹配成功，返归子串在主串中的第一个字符出现的位置
    } else {
      return -1;//最终匹配不成功，返回－１
    }

  }

  @Test
  public void test() {
    int flag = new BruteForce().bf("www.", "ww.");
    System.out.println(flag);
  }
}
