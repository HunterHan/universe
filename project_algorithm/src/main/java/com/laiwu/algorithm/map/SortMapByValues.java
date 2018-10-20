package com.laiwu.algorithm.map;

import java.util.*;

public class SortMapByValues {

  public static void main(String[] args) {

    Map<String,Integer> aMap = new HashMap<String,Integer>();

    // adding keys and values
    aMap.put("Five", 5);
    aMap.put("Seven", 7);
    aMap.put("Eight", 8);
    aMap.put("One",1);
    aMap.put("Two",2);
    aMap.put("Three", 3);

    sortMapByValues(aMap);

  }

  /**
   * 对HashMap按键值排序
   * @param aMap
   */
  private static void sortMapByValues(Map<String, Integer> aMap) {

    Set<Map.Entry<String,Integer>> mapEntries = aMap.entrySet();

    System.out.println("Values and Keys before sorting ");
    for(Map.Entry<String,Integer> entry : mapEntries) {
      System.out.println(entry.getValue() + " - "+ entry.getKey());
    }

    // used linked list to sort, because insertion of elements in linked list is faster than an array list.
    List<Map.Entry<String,Integer>> aList = new LinkedList<Map.Entry<String,Integer>>(mapEntries);

    // sorting the List
    Collections.sort(aList, new Comparator<Map.Entry<String,Integer>>() {

      @Override
      public int compare(Map.Entry<String, Integer> ele1,
                         Map.Entry<String, Integer> ele2) {

        return ele1.getValue().compareTo(ele2.getValue());
      }
    });

    // Storing the list into Linked HashMap to preserve the order of insertion.
    Map<String,Integer> aMap2 = new LinkedHashMap<String, Integer>();
    for(Map.Entry<String,Integer> entry: aList) {
      aMap2.put(entry.getKey(), entry.getValue());
    }

    // printing values after soring of map
    System.out.println("Value " + " - " + "Key");
    for(Map.Entry<String,Integer> entry : aMap2.entrySet()) {
      System.out.println(entry.getValue() + " - " + entry.getKey());
    }

  }
}