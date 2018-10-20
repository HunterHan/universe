package com.laiwu.source.code.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ByteBufUtilTest {

  @Test
  public void test() {
    ByteBuf byteBuf = Unpooled.copiedBuffer("a".getBytes());
    System.out.println(ByteBufUtil.hexDump(byteBuf.readBytes(byteBuf.readableBytes())));


  }
}
