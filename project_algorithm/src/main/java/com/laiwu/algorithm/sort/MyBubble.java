package com.laiwu.algorithm.sort;

import java.util.Arrays;

/**
 * Title: 交换排序中的冒泡排序 ，一般情形下指的是优化后的冒泡排序，最多进行 n-1 次比较
 * Description: 因为越大的元素会经由交换慢慢 "浮" 到数列的顶端 (最后位置)，最大的数最后才确定下来，所以称为冒泡排序
 * 时间复杂度：最好情形 O(n)，平均情形 O(n^2)，最差情形 O(n^2) 
 * 空间复杂度：O(1) 
 * 稳 定 性：稳定
 * 内部排序 (在排序过程中数据元素完全在内存)
 * 
 * @source from https://github.com/githubofrico/DataStructure.git
 */
public class MyBubble {
  /**     
   * @description 朴素冒泡排序 (共进行 n-1 次比较)
   */
  public static int[] bubbleSort(int[] target) {
    int n = target.length;
    if (target != null && n != 1) {
      // 最多需要进行 n-1 躺，每一趟将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
      for (int i = 0; i < n - 1; i++) {
        for (int j = n - 1; j > i; j--) {
          if (target[j] < target[j - 1]) {
            int temp = target[j];
            target[j] = target[j - 1];
            target[j - 1] = temp;
          }
        }
        System.out.println(Arrays.toString(target));
      }
    }
    return target;
  }

  /**     
   * @description 优化冒泡排序
   */
  public static int[] optimizeBubbleSort(int[] target) {
    int n = target.length;
    if (target != null && n != 1) {
      // 最多需要进行 n-1 躺，每一趟将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
      for (int i = 0; i < n - 1; i++) {
        // 用来标志是否发生过元素交换
        boolean isExchanged = false;
        for (int j = n - 1; j > i; j--) {
          if (target[j] < target[j - 1]) {
            int temp = target[j];
            target[j] = target[j - 1];
            target[j - 1] = temp;
            isExchanged = true;
          }
        }
        System.out.println(Arrays.toString(target));
        // 未发生元素交换，则表示数组已有序，直接返回
        if (!isExchanged) {
          return target;
        }
      }
    }
    return target;
  }
}
