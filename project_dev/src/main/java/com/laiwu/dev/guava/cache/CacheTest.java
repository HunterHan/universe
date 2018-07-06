package com.laiwu.dev.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {

  private static Integer flag = 0;

  @Test
  public void testLoad() throws Exception {
    LoadingCache<String, Object> loadingCache = CacheBuilder.newBuilder().build(new CacheLoader<String, Object>() {
      @Override
      public Object load(String key) throws Exception {
        flag++;
        System.out.println("load value for key:" + key);
        return key + "";
      }
    });
    //第一次查询会执行cache的load方法,第二次直接从缓存获取
    System.out.println(loadingCache.get("key1"));
    System.out.println(loadingCache.get("key1"));
    System.out.println(flag);

    for (int i = 0; i < 10000; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            loadingCache.get("key1");
          } catch (ExecutionException e) {
            e.printStackTrace();
          }
        }
      }).start();

      System.out.print(flag);

    }

    System.out.println("\n" + flag);

  }

  @Test
  public void testEviction() throws Exception {
    //设置cache的最大size为5，并监听删除事件，一旦有缓存数据被删除则会通知监听
    Cache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(5).removalListener(notification -> {
      System.out.println(notification.getValue() + " is removed");
    }).build();
    //放入5个对象
    for (int i = 0; i < 5; i++) {
      cache.put("key" + i, i);
    }
    //放入第6个对象，此时缓存已满，会根据LRU策略删除最早的数据
    cache.put("key" + 10, 10);
  }

  @Test
  public void testTimeBasedEviction() throws Exception {
    //写入30秒后过期，并监听删除事件，一旦有缓存数据被删除则会通知监听
    Cache<String, Object> cache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS)
        //为了查看过期效果，这里讲并发数改为了1？
        .concurrencyLevel(1)
        .removalListener(notification -> {
          System.out.println(notification.getValue() +
              " is removed at:" + System.currentTimeMillis() / 1000);
        }).build();
    //每隔10十秒一个对象，共放入5个对象,放入第4个对象时因为第1个已经过期则会删除第0个对象
    for (int i = 0; i <= 4; i++) {
      System.out.println("put key" + i + ":" + i + " at:" + System.currentTimeMillis() / 1000);
      cache.put("key" + i, i);
      Thread.sleep(12000);
    }
  }

  @Test
  public void testWeakKeys() throws Exception {
    LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().concurrencyLevel(1)
        //缓存key使用WeakReference包装,一旦gc执行则回收该key，guava会自动移除key所对应的entry
        .weakKeys().removalListener(notification -> {
          //注册监听，打印被回收的key对应的value
          //此时打印的key为null(因为被gc掉了)，value为实际值
          System.out.println("remove " + notification.getKey() + ":" + notification.getValue());
        }).build(new CacheLoader<String, String>() {
          @Override
          public String load(String key) throws Exception {
            System.out.println("load key:" + key);
            return "v(" + key.toString() + ")";
          }
        });
    int i = 1;
    while (true) {
      //通知jvm需要执行gc
      if (i % 5 == 0) {
        System.out.println("gc starting...");
        Thread.sleep(2000);
        System.gc();
      }
      Thread.sleep(1000);
      loadingCache.get("bird" + (i++) + "");
    }
  }

  @Test
  public void testWeakValues() throws Exception {
    LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().concurrencyLevel(1)
        //缓存value使用WeakReference包装,一旦gc执行则回收该value,guava会自动移除value所对应的entry
        .weakValues().removalListener(notification -> {
          //注册监听，打印被回收的key对应的value
          //此时打印的key为实际值，value为null(因为被gc掉了)
          System.out.println("remove " + notification.getKey() + ":" + notification.getValue());
        }).build(new CacheLoader<String, String>() {
          @Override
          public String load(String key) throws Exception {
            System.out.println("load key:" + key);
            return "v(" + key.toString() + ")";
          }
        });
    int i = 1;
    while (true) {
      //通知jvm需要执行gc
      if (i % 5 == 0)
        System.gc();
      Thread.sleep(1000);
      loadingCache.get("bird" + (i++) + "");
    }
  }

  @Test
  public void testStat() throws Exception {
    Cache<String, String> cache = CacheBuilder.newBuilder()
        //开启统计功能
        .recordStats()
        .maximumSize(5).build();
    for (int i = 0; i < 20; i++)
      cache.put(i + "", i + "");

    for (int i = 0; i < 30; i++) {
      cache.getIfPresent(i + "");
    }
    System.out.println(cache.stats().toString());
  }
}
