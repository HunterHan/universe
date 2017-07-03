package sort;

import java.util.Arrays;

import org.junit.Test;

import com.laiwu.algorithm.sort.MyBubbleSort;
import com.laiwu.algorithm.sort.MyInsertSort;
import com.laiwu.algorithm.sort.MyMergeSort;
import com.laiwu.algorithm.sort.MySelectSort;

public class SortTest {

  @Test
  public void bubbleSortTest() {
    int[] source = new int[] { 5, 4, 3, 2, 1 };
    int[] source2 = new int[] { 4, 5, 3, 2, 1 };
    System.out.println("simple bubble sort\n");
    MyBubbleSort.bubbleSort(source);
    System.out.println("\noptimized bubble sort\n");
    MyBubbleSort.optimizeBubbleSort(source2);
  }

  @Test
  public void selectSortTest() {
    int[] source = new int[] { 5, 4, 3, 2, 1 };
    System.out.println("insert sort\n");
    MySelectSort.selectSort(source);
  }

  @Test
  public void insertSortTest() {
    int[] source = new int[] { 4, 5, 3, 2, 1 };
    System.out.println("insert sort\n");
    MyInsertSort.insertSort(source);
  }

  @Test
  public void mergeSortTest() {
    int[] source = new int[] { 6, 5, 4, 3, 2, 1 };
    System.out.println("merge sort by recursive\n");
    MyMergeSort.recursiveMergeSort(source, 0, source.length - 1);
    int[] source2 = new int[] { 6, 5, 4, 3, 2, 1 };
    System.out.println("merge sort by iterate\n");
    MyMergeSort.iterateMergeSort(source2);
  }

}
