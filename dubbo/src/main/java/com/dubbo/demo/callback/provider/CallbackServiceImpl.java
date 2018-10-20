package com.dubbo.demo.callback.provider;

import com.dubbo.demo.callback.consumer.CallbackListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CallbackServiceImpl implements CallbackService {

  private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<String, CallbackListener>();

  public CallbackServiceImpl() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        while (true) {
          try {
            Set<Map.Entry<String, CallbackListener>> entries = listeners.entrySet();
            System.out.println(entries.size());
            for (Map.Entry<String, CallbackListener> entry : entries) {
              try {
                String key = entry.getKey();
                System.out.println(key);
                entry.getValue().changed(getChanged(key));
              } catch (Throwable t) {
                listeners.remove(entry.getKey());
                t.printStackTrace();
              }
            }
            System.out.println("begin sleep...");
            Thread.sleep(5000); // 定时触发变更通知
            System.out.println("end sleep...");
          } catch (Throwable t) { // 防御容错
            t.printStackTrace();
            System.out.println(t.getMessage());

          }
        }
      }
    });
    t.setDaemon(true);
    t.start();
  }

  public void addListener(String key, CallbackListener listener) {
    listeners.put(key, listener);
    listener.changed(getChanged(key)); // 发送变更通知
    // System.out.println("发送变更通知。。。");
    // listeners.remove(key);
  }

  private String getChanged(String key) {
    return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
}