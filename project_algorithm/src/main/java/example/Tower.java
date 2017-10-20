package example;

import org.junit.Test;

public class Tower {

  /**
   * 递归实现汉诺塔
   *
   * @param TowerCount
   * @param left
   * @param mid
   * @param right
   */
  public void recursionHanoi(int TowerCount, char left, char mid, char right) {

    if (TowerCount == 1) {
      System.out.println(left + " --> " + right + "\n");
    } else {
      recursionHanoi(TowerCount - 1, left, right, mid);
      System.out.println(left + " --> " + right + "\n");
      recursionHanoi(TowerCount - 1, mid, left, right);
    }

  }

  @Test
  public void test() {

    int towerCount = 3;

    new Tower().recursionHanoi(towerCount, 'A', 'B', 'C');
  }
}
