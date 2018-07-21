package com.laiwu.dev.db.redis;

import lombok.Getter;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.List;

@Getter
public class JedisTest {

  @Test
  public void testNormal() {
    Jedis jedis = new Jedis("localhost", 6379);
    //jedis.auth("123456");
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      String result = jedis.set("normal" + i, "normal" + i);
    }
    long end = System.currentTimeMillis();
    System.out.println("Normal SET: " + ((end - start) / 1000.0) + " seconds");
    jedis.disconnect();
  }

  //redis事务，一个client发起的事务中的命令可以连续执行，中间不会插入其他指令。
  //可以调用jedis.watch()方法来监控key,如果调用后的key值发生变化，则事务执行失败。使用tx.discard()方法取消事务。
  //注：事务中某个操作执行失败，并不会回滚其他操作。
  @Test
  public void transactionsFunction() {
    Jedis jedis = new Jedis("localhost", 6379);
    // jedis.auth("123456");
    long start = System.currentTimeMillis();
    Transaction tx = jedis.multi();
    for (int i = 0; i < 10000; i++) {
      tx.set("transaction" + i, "transaction" + i);
    }
    List<Object> results = tx.exec();
    long end = System.currentTimeMillis();
    System.out.println("Transaction SET: " + ((end - start) / 1000.0) + " seconds");
    jedis.disconnect();

  }

  @Test
  public void testPipeline() {
    Jedis jedis = new Jedis("localhost", 6379);
    //jedis.auth("123456");
    Pipeline pipeline = jedis.pipelined();
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      pipeline.set("pipeline" + i, "pipeline" + i);
    }
    List<Object> results = pipeline.syncAndReturnAll();
    long end = System.currentTimeMillis();
    System.out.println("Pipeline SET : " + ((end - start) / 1000.0) + " seconds");
    jedis.disconnect();
  }

  //在管道中使用事务，但是效率并不比但多使用事务效率高很多。
  @Test
  public void combPipelineTranscationFunction() {
    Jedis jedis = new Jedis("localhost", 6379);
    // jedis.auth("123456");
    long start = System.currentTimeMillis();
    Pipeline pipeline = jedis.pipelined();
    pipeline.multi();
    for (int i = 0; i < 100000; i++) {
      pipeline.set("" + i, "" + i);
    }
    pipeline.exec();
    List<Object> results = pipeline.syncAndReturnAll();
    long end = System.currentTimeMillis();
    System.out.println("Pipelined transaction: " + ((end - start) / 1000.0) + " seconds");
    jedis.disconnect();
  }

  @Test
  //分布式直接连接，并且是同步调用，每步执行都返回执行结果。
  public static void shardNormalFunction() {
    List<JedisShardInfo> shards = Arrays.asList(
        new JedisShardInfo("localhost", 6379),
        new JedisShardInfo("localhost", 6380));
    ShardedJedis sharding = new ShardedJedis(shards);
    long start = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++) {
      String result = sharding.set("shardNormal" + i, "shardNormal" + i);
    }
    long end = System.currentTimeMillis();
    System.out.println("Simple@Sharing SET: " + ((end - start) / 1000.0) + " seconds");
    sharding.disconnect();
  }

  @Test
  //分布式直接连接，并且是异步调用，不是每步执行都返回执行结果
  public void shardpipelinedFunction() {
    List<JedisShardInfo> shards = Arrays.asList(
        new JedisShardInfo("localhost", 6379),
        new JedisShardInfo("localhost", 6380));
    ShardedJedis sharding = new ShardedJedis(shards);
    ShardedJedisPipeline pipeline = sharding.pipelined();
    long start = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++) {
      pipeline.set("shardpipelined" + i, "shardpipelined" + i);
    }
    List<Object> results = pipeline.syncAndReturnAll();
    long end = System.currentTimeMillis();
    System.out.println("Pipelined@Sharing SET: " + ((end - start) / 1000.0) + " seconds");
    sharding.disconnect();
  }
}
