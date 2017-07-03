package sort;

import java.util.Arrays;

import org.junit.Test;

import com.laiwu.algorithm.sort.MyBubbleSort;
import com.laiwu.algorithm.sort.MyInsertSort;
import com.laiwu.algorithm.sort.MyMergeSort;
import com.laiwu.algorithm.sort.MyQuickSort;
import com.laiwu.algorithm.sort.MySelectSort;

public class SortTest {

  @Test
  public void bubbleSortTest() {
    int[] source = new int[] { 5, 4, 3, 2, 1 };
    int[] source2 = new int[] { 5, 4, 3, 2, 1 };
    System.out.println("simple bubble sort\n\n\t" + Arrays.toString(source));
    MyBubbleSort.bubbleSort(source);
    System.out.println("\noptimized bubble sort\n\n\t" + Arrays.toString(source2));
    MyBubbleSort.optimizeBubbleSort(source2);
  }

  @Test
  public void selectSortTest() {
    int[] source = new int[] { 5, 4, 3, 2, 1 };
    System.out.println("select sort source\n\n\t\t" + Arrays.toString(source));
    MySelectSort.selectSort(source);
  }

  @Test
  public void insertSortTest() {
    int[] source = new int[] { 5, 4, 3, 2, 1 };
    System.out.println("insert sort source\n\n\t" + Arrays.toString(source));
    MyInsertSort.insertSort(source);
  }

  @Test
  public void mergeSortTest() {
    int[] source = new int[] { 8, 7, 6, 5, 4, 3, 2, 1 };
    System.out.println("merge sort by recursive\n");
    MyMergeSort.recursiveMergeSort(source, 0, source.length - 1);
    int[] source2 = new int[] { 8, 7, 6, 5, 4, 3, 2, 1 };
    System.out.println("merge sort by iterate\n");
    MyMergeSort.iterateMergeSort(source2);
  }

  @Test
  public void quickSortTest() {
    int[] source = new int[] { 8, 7, 6, 5, 4, 3, 2, 1 };
    System.out.println("quick sort source\n\n\t" + Arrays.toString(source));
    MyQuickSort.quickSort(source, 0, source.length - 1);

  }
}
