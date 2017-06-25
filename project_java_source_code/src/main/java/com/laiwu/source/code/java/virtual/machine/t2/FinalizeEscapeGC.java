package com.laiwu.source.code.java.virtual.machine.t2;

public class FinalizeEscapeGC {
  public static FinalizeEscapeGC SAVE_HOOK = null;

  public void alive() {
    System.out.println("yes,I am still alive:)");
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("finalize method executed.");
    FinalizeEscapeGC.SAVE_HOOK = this;
  }

  public static void main(String[] args) throws Throwable {
    SAVE_HOOK = new FinalizeEscapeGC();

    SAVE_HOOK = null;
    System.gc();
    Thread.sleep((long) 1);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.alive();
    } else {
      System.out.println("no, I am dead~");
    }

    SAVE_HOOK = null;
    System.gc();
    Thread.sleep((long) 1);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.alive();
    } else {
      System.out.println("no, I am dead:(");
    }
  }
}
