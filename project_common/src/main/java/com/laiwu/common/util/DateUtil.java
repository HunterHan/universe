package com.laiwu.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
  // 增加或减少天数
  public static Date addDay(Date date, int num) {
    Calendar startDT = Calendar.getInstance();
    startDT.setTime(date);
    startDT.add(Calendar.DAY_OF_MONTH, num);
    return startDT.getTime();
  }
}
