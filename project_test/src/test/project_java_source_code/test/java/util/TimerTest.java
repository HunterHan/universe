package test.java.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import com.laiwu.common.constant.DateConstant;
import com.laiwu.common.util.date.CalendarUtil;
import com.laiwu.common.util.date.DateUtil;
import com.laiwu.source.code.java.util.MyTimer;

public class TimerTest {
//  junit不支持线程
//  @Test
//  public void timerTest() {
//    MyTimer.schedule(0, 1000);
//  }

  public static void main(String[] args) {
    /**
     * 每隔一段时间执行任务
     */
    // MyTimer.schedule(0, 1000);

    /**
     * 从当前开始，每隔一段时间执行任务
     */
    /*    Date beginDate = new Date();
    beginDate.setTime(System.currentTimeMillis());
    long period = 24 * 60 * 60 * 1000;// 隔一天执行一次任务
    // long period = 5 * 1000;//隔5秒执行一次任务
    MyTimer.schedule(beginDate, period);*/

    /**
     * 定时每天凌晨1点执行任务
     */
    Date beginDate = CalendarUtil.getAssignDate(1, 0, 0); // 第一次执行定时任务的时间
    // 如果第一次执行定时任务的时间 小于当前的时间
    // 此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
    if (beginDate.before(new Date())) {
      beginDate = DateUtil.addDay(beginDate, 1);
    }
    TimerTask task = new TimerTask() {

      @Override
      public void run() {

        System.out.println("...");
      }
    };

    MyTimer.schedule(task, beginDate, DateConstant.PERIOD_1_DAY);
  }

}
