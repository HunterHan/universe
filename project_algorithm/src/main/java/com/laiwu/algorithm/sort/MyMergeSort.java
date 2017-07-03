package com.laiwu.algorithm.sort;

import java.util.Arrays;

/**
 * Title: 归并排序 ，概念上最为简单的排序算法，是一个递归算法
 * Description: 归并排序包括两个过程：归 和 并
 * "归" 是指将原序列分成半子序列，分别对子序列进行『递归』排序
 * "并" 是指将排好序的各子序列合并成原序列
 * 
 * 归并排序的主要问题是：需要一个与原待排序数组一样大的辅助数组空间
 * 
 * 归并排序不依赖于原始序列，因此其最好情形、平均情形和最差情形时间复杂度都一样
 * 时间复杂度：最好情形 O(n)，平均情形 O(n^2)，最差情形 O(n^2) 
 * 空间复杂度：O(n) 
 * 稳 定 性：稳定
 * 内部排序 (在排序过程中数据元素完全在内存)
 * 
 */
public class MyMergeSort {

  /**     
   * @description 归并排序算法 (递归算法)：递去分解，归来合并
   * @param target 待排序序列
   * @param left  待排序序列起始位置
   * @param right  待排序序列终止位置
   * @return     
   */
  public static int[] recursiveMergeSort(int[] target, int left, int right) {

    if (right > left) { // 递归终止条件
      int mid = (left + right) / 2;
      recursiveMergeSort(target, left, mid); // 归并排序第一个子序列
      recursiveMergeSort(target, mid + 1, right); // 归并排序第二个子序列
      return recursiveMergeTerminitor(target, left, mid, right); // 合并子序列成原序列
    }
    return target;
  }

  /**     
   * @description 两路归并算法
   * @param target 用于存储归并结果
   * @param left 第一个有序表的第一个元素所在位置
   * @param mid  第一个有序表的最后一个元素所在位置
   * @param right  第二个有序表的最后一个元素所在位置
   * @return     
   */
  public static int[] recursiveMergeTerminitor(int[] target, int left, int mid, int right) {

    // 需要一个与原待排序数组一样大的辅助数组空间
    int[] temp = Arrays.copyOf(target, target.length);

    // s1,s2 是检查指针，index 是存放指针
    int s1 = left;
    int s2 = mid + 1;
    int index = left;

    // 两个表都未检查完，两两比较
    while (s1 <= mid && s2 <= right) {
      if (temp[s1] <= temp[s2]) { // 稳定性
        target[index++] = temp[s1++];
      } else {
        target[index++] = temp[s2++];
      }
    }

    // 若第一个表未检查完，复制
    while (s1 <= mid) {
      target[index++] = temp[s1++];
    }

    // 若第二个表未检查完，复制
    while (s2 <= right) {
      target[index++] = temp[s2++];
    }

    System.out.println(Arrays.toString(target));
    return target;
  }

  /**
   * 迭代实现归并排序
   */
  public static int[] iterateMergeSort(int[] target) {
    int targetLength = target.length;
    // base condition
    if (targetLength < 2) {
      return target;
    }

    int middleIndex = targetLength / 2;
    int[] leftTarget = new int[middleIndex];
    int[] rightTarget = new int[targetLength - middleIndex];

    for (int i = 0; i < middleIndex; i++) {
      leftTarget[i] = target[i];
    }
    for (int i = middleIndex; i < targetLength; i++) {
      rightTarget[i - middleIndex] = target[i];
    }

    System.out.println(Arrays.toString(leftTarget) + Arrays.toString(rightTarget));

    iterateMergeSort(leftTarget);
    iterateMergeSort(rightTarget);

    iterateMergeSortTerminitor(leftTarget, rightTarget, target);

    return target;
  }

  public static int[] iterateMergeSortTerminitor(int[] leftArray, int[] rightArray, int[] target) {
    int leftLength = leftArray.length;
    int rightLength = rightArray.length;
    int leftIndex = 0, rightIndex = 0, targetIndex = 0;

    while (leftIndex < leftLength && rightIndex < rightLength) {
      if (leftArray[leftIndex] <= rightArray[rightIndex]) {
        target[targetIndex] = leftArray[leftIndex];
        leftIndex++;
      } else {
        target[targetIndex] = rightArray[rightIndex];
        rightIndex++;
      }
      targetIndex++;
    }

    while (leftIndex < leftLength) {
      target[targetIndex] = leftArray[leftIndex];
      targetIndex++;
      leftIndex++;
    }

    while (rightIndex < rightLength) {
      target[targetIndex] = rightArray[rightIndex];
      targetIndex++;
      rightIndex++;
    }

    return target;
  }

}
