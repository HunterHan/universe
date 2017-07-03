package com.laiwu.algorithm.sort;

import java.util.Arrays;

/**
 * Title: 交换排序中的快速排序，目前应用最为广泛的排序算法，是一个递归算法
 * Description: 快速排序包括两个过程：划分 和 快排
 * "划分" 是指将原序列按基准元素划分两个子序列
 * "快排" 是指分别对子序列进行快排
 * 
 * 就平均计算时间而言，快速排序是所有内部排序方法中最好的一个
 * 
 * 对于大的、随机数列表一般相信是最快的已知排序
 * 
 * 对大规模数据排序时，快排是快的；对小规模数据排序时，快排是慢的，甚至慢于简单选择排序等简单排序方法
 * 
 * 快速排序依赖于原始序列，因此其时间复杂度从 O(nlogn) 到 O(n^2) 不等
 * 时间复杂度：平均情形 O(nlogn)，最好情形 O(nlogn)，最差情形 O(n^2)
 * 
 * 递归所消耗的栈空间
 * 由于递归调用，快排的空间复杂度是 O(logn)
 * 快排的实现是递归调用的， 而且每次函数调用中只使用了常数的空间，因此空间复杂度等于递归深度 O(logn)
 * 空间复杂度：O(logn)
 * 
 * 稳 定 性：不稳定  可选任一元素作为基准元素
 * 
 * 内部排序 (在排序过程中数据元素完全在内存)
 * 
 * 为什么不像归并排序使用辅助数组？因为归并排序中『归』得到的两个数组，无法脱离辅助数组而直接放回原数组中，
 * 快速排序自始至终在原数组中进行元素的交换和比较和移位
 */
public class MyQuickSort {

  /**     
   * @description 快排算法 (递归算法)：在递去过程中就把问题解决了
   * @param segment  不适用任何auxiliary array or new array, 使用用一个array即可，因此空间复杂度
   * @param leftIndex
   * @param rightIndex
   * @return     
   */
  public static int[] quickSort(int[] segment, int leftIndex, int rightIndex) {

    if (leftIndex < rightIndex) { // 递归终止条件，exit condition
      int partitionIndex = partition(segment, leftIndex, rightIndex); // 原序列划分后基准元素的位置，寻找povit
      System.out.println("\n\tafter partition array - " + Arrays.toString(segment));
      quickSort(segment, leftIndex, partitionIndex - 1); // 对第一个子序列快速排序，不包含基准元素！小于povit，左分区，不必有序
      quickSort(segment, partitionIndex + 1, rightIndex); // 对第二个子序列快速排序，不包含基准元素！大于povit，右分区，不必有序
      return segment;
    }
    return segment;
  }

  /**     
   * @description 序列划分逻辑，以第一个元素为基准元素
   * @param target  序列
   * @param left 序列左端
   * @param right  序列右端
   * @return     
   */
  public static int partition(int[] target, int left, int right) {

    int partitionPovitValue = target[left]; // 基准元素的值，当然也可以一开始从最右侧元素作为povitPartitionValue，结果是一样的
    int partitionIndex = left; // 基准元素最终应该在的位置

    for (int i = left + 1; i <= right; i++) { // 从基准元素的下一个元素开始
      if (target[i] < partitionPovitValue) { // 若其小于基准元素
        partitionIndex++; // 若其小于基准元素, 则基准元素最终位置后移；否则不用移动
        if (partitionIndex != i) { // 相等情况意味着 i 之前的元素都小于 base, 只需要换一次即可，不需要次次都换
          int temp = target[partitionIndex];
          target[partitionIndex] = target[i];
          target[i] = temp;
        }
      }
    }

    // 将基准元素就位
    target[left] = target[partitionIndex];
    target[partitionIndex] = partitionPovitValue;

    System.out.println("\n\tpartitionIndex - " + partitionIndex);
    System.out.println("\tpartitionPovitvalue - " + partitionPovitValue);

    return partitionIndex; // 返回划分后基准元素的位置
  }
}