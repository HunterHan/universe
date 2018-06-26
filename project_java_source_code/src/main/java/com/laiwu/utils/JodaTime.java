package com.laiwu.utils;

import com.google.common.collect.Lists;
import com.laiwu.common.constant.DateConstant;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class JodaTime {

  @Test
  public void test() {
    DateTime time = new DateTime();
    System.out.println(time.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));

    /* --属性获取-- */
    DateTime.Property year = time.year();
    System.out.println("年\t\t\t" + year.get());
    DateTime.Property month = time.monthOfYear();
    System.out.println("月\t\t\t" + month.get());
    DateTime.Property weekOfWeekyear = time.weekOfWeekyear();
    System.out.println("周\t\t\t" + weekOfWeekyear.get());
    DateTime.Property dayOfYear = time.dayOfYear();
    System.out.println("日(年)\t\t\t" + dayOfYear.get());
    DateTime.Property dayOfMonth = time.dayOfMonth();
    System.out.println("日(月)\t\t\t" + dayOfMonth.get());
    DateTime.Property dayOfWeek = time.dayOfWeek();
    System.out.println("日(周)\t\t\t" + dayOfWeek.get());
    DateTime.Property hourOfDay = time.hourOfDay();
    System.out.println("小时\t\t\t" + hourOfDay.get());
    DateTime.Property minuteOfDay = time.minuteOfDay();
    System.out.println("分钟(天)\t\t\t" + minuteOfDay.get());
    DateTime.Property minuteOfHour = time.minuteOfHour();
    System.out.println("分钟(小时)\t\t\t" + minuteOfHour.get());
    DateTime.Property secondOfDay = time.secondOfDay();
    System.out.println("秒(天)\t\t\t" + secondOfDay.get());
    DateTime.Property secondOfMinute = time.secondOfMinute();
    System.out.println("秒(分钟)\t\t\t" + secondOfMinute.get());
    DateTime.Property millisOfDay = time.millisOfDay();
    System.out.println("毫秒(分钟)\t\t\t" + millisOfDay.get());
    DateTime.Property millisOfSecond = time.millisOfSecond();
    System.out.println("毫秒(秒)\t\t\t" + millisOfSecond.get());

    /* --属性调整-- */
    DateTime time2 = time.minusYears(1);
    System.out.println("减一年\t\t\t" + time2.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time3 = time.minusMonths(1);
    System.out.println("减一月\t\t\t" + time3.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time4 = time.minusWeeks(1);
    System.out.println("减一周\t\t\t" + time4.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time5 = time.minusDays(1);
    System.out.println("减一日\t\t\t" + time5.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time6 = time.minusHours(1);
    System.out.println("减一小时\t\t\t" + time6.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time7 = time.minusMinutes(1);
    System.out.println("减一分钟\t\t\t" + time7.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time8 = time.minusSeconds(1);
    System.out.println("减一秒\t\t\t" + time8.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time9 = time.minusMillis(1);
    System.out.println("减一毫秒\t\t\t" + time9.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time10 = time.minus(1L);
    System.out.println("减一毫秒\t\t\t" + time10.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));

    DateTime time11 = time.plusYears(1);
    System.out.println("加一年\t\t\t" + time11.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time12 = time.plusMonths(1);
    System.out.println("加一月\t\t\t" + time12.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time13 = time.plusWeeks(1);
    System.out.println("加一周\t\t\t" + time13.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time14 = time.plusDays(1);
    System.out.println("加一日\t\t\t" + time14.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time15 = time.plusHours(1);
    System.out.println("加一小时\t\t\t" + time15.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time16 = time.plusMinutes(1);
    System.out.println("加一分钟\t\t\t" + time16.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time17 = time.plusSeconds(1);
    System.out.println("加一秒\t\t\t" + time17.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time18 = time.plusMillis(1);
    System.out.println("加一毫秒\t\t\t" + time18.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time19 = time.plus(1L);
    System.out.println("加一毫秒\t\t\t" + time19.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));

    /* --属性比较-- */
    int difference = time2.year().getDifference(time);
    System.out.println("时间差：" + difference + "年");
    difference = time3.monthOfYear().getDifference(time);
    System.out.println("时间差：" + difference + "月");
    difference = time4.weekOfWeekyear().getDifference(time);
    System.out.println("时间差：" + difference + "周");
    difference = time5.dayOfYear().getDifference(time);
    System.out.println("时间差：" + difference + "日");
    difference = time5.dayOfMonth().getDifference(time);
    System.out.println("时间差：" + difference + "日");
    difference = time5.dayOfWeek().getDifference(time);
    System.out.println("时间差：" + difference + "日");
    difference = time6.hourOfDay().getDifference(time);
    System.out.println("时间差：" + difference + "小时");
    difference = time7.minuteOfDay().getDifference(time);
    System.out.println("时间差：" + difference + "分钟");
    difference = time7.minuteOfHour().getDifference(time);
    System.out.println("时间差：" + difference + "分钟");
    difference = time8.secondOfMinute().getDifference(time);
    System.out.println("时间差：" + difference + "秒");
    difference = time8.secondOfDay().getDifference(time);
    System.out.println("时间差：" + difference + "秒");
    difference = time9.millisOfDay().getDifference(time);
    System.out.println("时间差：" + difference + "毫秒");
    difference = time9.millisOfSecond().getDifference(time);
    System.out.println("时间差：" + difference + "毫秒");
    difference = time10.millisOfDay().getDifference(time);
    System.out.println("时间差：" + difference + "毫秒");
    difference = time10.millisOfSecond().getDifference(time);
    System.out.println("时间差：" + difference + "毫秒");

    /* --属性设置-- */
    DateTime time30 = time.withYear(1990);
    System.out.println("属性设置(年)：" + time30.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time31 = time.withYearOfCentury(20);
    System.out.println("属性设置(年)：" + time31.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time32 = time.withYearOfEra(1990);
    System.out.println("属性设置(年)：" + time32.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time33 = time.withMonthOfYear(1);
    System.out.println("属性设置(月)：" + time33.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time34 = time.withWeekOfWeekyear(1);
    System.out.println("属性设置(周)：" + time34.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time35 = time.withWeekyear(2017);
    System.out.println("属性设置(周)：" + time35.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time36 = time.withDayOfYear(1);
    System.out.println("属性设置(日)：" + time36.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time37 = time.withDayOfMonth(1);
    System.out.println("属性设置(日)：" + time37.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time38 = time.withDayOfWeek(1);
    System.out.println("属性设置(日)：" + time38.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time39 = time.withHourOfDay(1);
    System.out.println("属性设置(小时)：" + time39.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time40 = time.withMinuteOfHour(1);
    System.out.println("属性设置(分钟)：" + time40.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time41 = time.withSecondOfMinute(1);
    System.out.println("属性设置(秒)：" + time41.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time42 = time.withMillisOfDay(1);
    System.out.println("属性设置(毫秒)：" + time42.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));
    DateTime time43 = time.withMillisOfSecond(1);
    System.out.println("属性设置(毫秒)：" + time43.toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss));

    /* --格式化-- */
    String string = DateTime.now().toString(DateConstant.YYYY_MM_DD_HH_MM_SS_sss);
    System.out.println("格式化输出：" + string);

    /* --Interval/Duration/Period --*/
    DateTime start = new DateTime(2017, 12, 2, 15, 33, 20, 500);//开始时间
    DateTime end = new DateTime(2018, 6, 1, 12, 34, 20, 300);//结束时间
    DateTime anyDateTime = new DateTime(2018, 1, 1, 12, 34);
    Interval interval = new Interval(start, end);
    Duration duration = new Duration(start, end);
    Period period = interval.toPeriod();

    boolean between = interval.contains(anyDateTime);
    long durationMillis = duration.getMillis();
    long periodMillis = period.getMillis();

    System.out.println("between:\t" + between);
    System.out.println("duration:\t" + durationMillis);
    System.out.println("period:\t\t" + periodMillis);

    /* -- java.util.Date 和 joda 转换 -- */
    java.util.Date date = new Date();
    DateTime jodaDateTime = new DateTime(date);
    Date date1 = jodaDateTime.toDate();
    System.out.println("joda datetime：" + jodaDateTime);
    System.out.println("java.util.Date：" + date);
    System.out.println("java.util.Date：" + date1);

    java.util.Calendar calendar = Calendar.getInstance();
    DateTime dateTime = new DateTime(calendar);
    Calendar calendar2 = dateTime.toCalendar(Locale.CHINESE);
    System.out.println("joda datetime：" + dateTime);
    System.out.println("java.util.Calendar：" + calendar);
    System.out.println("java.util.Calendar：" + calendar2);
  }

}
