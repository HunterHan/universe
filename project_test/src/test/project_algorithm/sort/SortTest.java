package sort;

import org.junit.Test;

import com.laiwu.algorithm.sort.MyBubble;

public class SortTest {

  @Test
  public void bubbleTest() {
    int[] source = new int[] { 5, 4, 3, 2, 1 };
    int[] source2 = new int[] { 4, 5, 3, 2, 1 };
    System.out.println("simple bubble sort\n");
    MyBubble.bubbleSort(source);
    System.out.println("optimized bubble sort\n");
    MyBubble.optimizeBubbleSort(source2);
  }
}
