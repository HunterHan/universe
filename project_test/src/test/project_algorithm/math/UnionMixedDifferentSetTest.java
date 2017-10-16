package math;

import java.util.HashSet;
import java.util.Set;

import com.laiwu.algorithm.math.UnionMixedDifferentSet;
import org.junit.Before;
import org.junit.Test;

public class UnionMixedDifferentSetTest {
  public static Set<Integer> set1 = new HashSet<>();
  public static Set<Integer> set2 = new HashSet<>();

  @Before public void prepare() {

    set1.add(1);
    set1.add(2);
    set1.add(3);
    set2.add(3);
    set2.add(4);
    set2.add(5);
    set2.add(1);
  }

  @Test public void getUnionSetTest() {

    Set<Integer> result = UnionMixedDifferentSet.getUnionSet(set1, set2);
    System.out.println("并集:\t" + result);
  }

  @Test public void getMixedSetTest() {
    Set<Integer> result = UnionMixedDifferentSet.getMixedSet(set1, set2);
    System.out.println("交集:\t" + result);
  }

  /**
   * 差集，等价于并集抛去交集的剩余元素
   */
  @Test public void getDifferentSetTest() {
    Set<Integer> unionSetResult = UnionMixedDifferentSet.getUnionSet(set1, set2);
    Set<Integer> mixedSetResult = UnionMixedDifferentSet.getMixedSet(set1, set2);
    Set<Integer> DifferentSetResult = new HashSet<>(unionSetResult);
    DifferentSetResult.removeAll(mixedSetResult);
    System.out.println("差集:\t" + DifferentSetResult);
  }
}
