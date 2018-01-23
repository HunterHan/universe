package com.laiwu.source.code.java.lang.thread;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUUID {

  private final static InheritableThreadLocal<Map<String, Object>> THREAD_VARIABLES = new InheritableThreadLocal<Map<String, Object>>() {
    /**
     * @see java.lang.ThreadLocal#initialValue()
     */
    @Override
    protected Map<String, Object> initialValue() {
      return new HashMap<String, Object>();
    }
  };

  @SuppressWarnings("unchecked")
  public static <T> T getThreadVariable(String name) {
    return (T) THREAD_VARIABLES.get().get(name);
  }

  @SuppressWarnings("unchecked")
  public static <T> T getThreadVariable(String name, T initialValue) {
    T o = (T) THREAD_VARIABLES.get().get(name);
    if (o == null) {
      THREAD_VARIABLES.get().put(name, initialValue);
      return getThreadVariable(name);
    } else {
      return o;
    }
  }

  public static void setThreadVariable(String name, Object value) {
    THREAD_VARIABLES.get().put(name, value);
  }

  public static void destroy() {
    THREAD_VARIABLES.remove();
//    System.out.println(Thread.currentThread().getName() + " : THREAD_VARIABLES Object destroy.....");
  }
}
