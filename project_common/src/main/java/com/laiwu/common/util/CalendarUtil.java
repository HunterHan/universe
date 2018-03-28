package com.laiwu.common.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

  public static Date getAssignDate(int hour, int minute, int second) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, hour); // 凌晨1点
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
    Date assignDate = calendar.getTime();
    return assignDate;
  }
}
