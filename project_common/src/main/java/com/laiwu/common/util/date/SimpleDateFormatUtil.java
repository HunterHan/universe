package com.laiwu.common.util.date;

import java.util.Date;

public class SimpleDateFormatUtil {

  /**
   * 计算时间差
   */
  public static float getDistance(long start) {
    Date end = new Date();
    return (end.getTime() - start) / 1000f;
  }
}
