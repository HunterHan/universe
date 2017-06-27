package com.laiwu.source.code.java.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class MyCalendar {

  @Test
  public void getXXX() {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    System.out.println("年:\t" + year);
    // Calendar的月份的下标是从0开始
    int month = calendar.get(Calendar.MONTH) + 1;
    System.out.println("月:\t" + month);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println("天:\t" + day);
    int hour = calendar.get(Calendar.HOUR);
    System.out.println("小时:\t" + hour);
    int minute = calendar.get(Calendar.MINUTE);
    System.out.println("分钟:\t" + minute);
    int second = calendar.get(Calendar.SECOND);
    System.out.println("秒:\t" + second);

    calendar.add(Calendar.MONTH, 1);
    System.out.println("\n加1个月:\t" + calendar.get(Calendar.MONTH));

    calendar.add(Calendar.DAY_OF_MONTH, 5);
    System.out.println("\n加5天:\t" + calendar.get(Calendar.DAY_OF_MONTH));

    calendar.add(Calendar.HOUR_OF_DAY, 2);
    System.out.println("\n加2个小时:\t" + calendar.get(Calendar.HOUR_OF_DAY));

    System.out.println(new Date());
  }

}
