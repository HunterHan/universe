package com.laiwu.algorithm.sort;

import java.util.Arrays;

/**        
 * Title: 选择排序中的『直接选择排序』 
 * Description: 每次找到数组中当前排序范围中的最小值并与该范围中的第一个数字交换，同时缩小待排序数组的排序范围
 *        时间复杂度：平均情形 O(n^2)，最好情形 O(n^2)，最差情形 O(n^2)
 *        空间复杂度：O(1)
 *        稳    定   性：不稳定
 *        内部排序 (在排序过程中数据元素完全在内存)
 */
public class MySelectSort {

  public static int[] selectSort(int[] target) {

    if (target != null && target.length != 1) {
      for (int i = 0; i < target.length; i++) {
        boolean isExistSmaller = false;
        int min_index = i;
        for (int j = i + 1; j < target.length; j++) {
          if (target[min_index] > target[j]) {
            min_index = j;
            isExistSmaller = true;
          }
        }
        if (target[min_index] != target[i]) { // 导致不稳定的因素：交换
          int min = target[min_index];
          target[min_index] = target[i];
          target[i] = min;
          System.out.println("\nunstable swap - " + Arrays.toString(target));
        }

        if (!isExistSmaller) {
          return target;
        }

        System.out.println("\n\t\t" + Arrays.toString(target));

      }
    }
    return target;
  }

  public static void main(String[] args) {

    int[] target = {5, 4, 3, 2, 3};
    target = selectSort(target);

  }

}
