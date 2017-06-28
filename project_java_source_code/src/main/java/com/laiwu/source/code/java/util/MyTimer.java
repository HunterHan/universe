package com.laiwu.source.code.java.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器，并不绝对精确，线程安全
 * @author CogniBoy
 *
 */
public class MyTimer {

  public static void schedule(TimerTask task, Date beginDate, long period) {

    Timer timer = new Timer();
    // 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
    timer.schedule(task, beginDate, period);
  }

  public static void schedule(int delay, int period) {
    TimerTask task = new TimerTask() {

      @Override
      public void run() {
        System.out.println("...");
      }
    };

    Timer timer = new Timer();
    timer.schedule(task, delay, period);
  }
}
