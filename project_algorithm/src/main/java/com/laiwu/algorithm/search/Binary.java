package com.laiwu.algorithm.search;

import org.junit.Test;

public class Binary {

  /**
   * 递归实现折半查找算法
   *
   * @param box
   * @param start
   * @param end
   * @param target
   * @return
   */
  public int binarySearch1(int[] box, int start, int end, int target) {

    if (box == null || box.length == 0 || target < box[start] || target > box[end]) {
      return -1;
    }

    int mid = (start + end) >>> 1;

    if (start <= end) {
      if (box[mid] == target) {
        return mid;
      } else if (box[mid] > target) {
        return binarySearch1(box, start, mid - 1, target);
      } else {
        return binarySearch1(box, mid + 1, end, target);
      }
    } else {
      return -1;
    }
  }

  public int binarySearch2(int[] box, int target) {

    if (box == null || box.length == 0 || target < box[0] || target > box[box.length - 1]) {
      return -1;
    }

    int start = 0;
    int end = box.length - 1;

    while (start <= end) {

      int mid = (start + end) >>> 1;

      int midVal = box[mid];

      if (target == midVal) {
        return mid;
      } else if (target < midVal) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }

  @Test
  public void test() {

    int target = 4;

    int[] box = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int index = new Binary().binarySearch1(box, 0, box.length - 1, target);
    System.out.println(index);

    int index2 = new Binary().binarySearch2(box, target);
    System.out.println(index2);

  }

}
