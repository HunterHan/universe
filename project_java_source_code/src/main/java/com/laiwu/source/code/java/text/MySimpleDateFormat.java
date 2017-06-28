package com.laiwu.source.code.java.text;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.laiwu.common.constant.DateConstant;

/**
 * SimpleDateFormat 是一个以国别敏感的方式格式化和分析数据的具体类。 
 * 允许格式化 (date -> text)、语法分析 (text -> date)和标准化
 * 
 * SimpleDateFormat函数的继承关系：
  Java.lang.Object
     |
     +----java.text.Format
             |
             +----java.text.DateFormat
                     |
                     +----java.text.SimpleDateFormat
 */
public class MySimpleDateFormat {

  /**
   * 对当前时间格式化并返回
   * @return 返回格式 2000-01-01 00:00:00
   */
  public static String formatNow() {
    Date now = new Date();
    SimpleDateFormat formetter = new SimpleDateFormat(DateConstant.DATE_FORMATTER_YYYY_MM_DD_HH_MM_SS);
    String nowStr = formetter.format(now);
    return nowStr;
  }

  /**
   * 计算时间差
   */
  public static long getDistance(long start) {
    Date end = new Date();
    return end.getTime() - start;
  }
}
