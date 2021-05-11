package com.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author user
 * 介绍在java中使用Jedis操作Redis的基本用法。
 * hash表。
 */
public class TestJedisHashMap {
    public static void main(String[] args) {
        // 連接本地的 Redis 服務
        Jedis jedis = new Jedis("localhost");
        // 查看服務是否運行
        System.out.println("服務正在運行且連接成功: " + jedis.ping());

        jedis.del("hash");
        Map map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        jedis.hmset("hash", map);
        jedis.hset("hash", "key5", "value5");
        System.out.println("散列hash的所有键值對為：" + jedis.hgetAll("hash"));
        System.out.println("散列hash的所有鍵為：" + jedis.hkeys("hash"));
        System.out.println("散列hash的所有值為：" + jedis.hvals("hash"));
        System.out.println("將key6保存的值加上一个整數，如果key6不存在則添加key6：" + jedis.hincrBy("hash", "key6", 6));
        System.out.println("散列hash的所有键值對為：" + jedis.hgetAll("hash"));
        System.out.println("將key6保存的值加上一个整數，如果key6不存在則添加key6：" + jedis.hincrBy("hash", "key6", 3));
        System.out.println("散列hash的所有键值對為：" + jedis.hgetAll("hash"));
        System.out.println("删除一個或者多个键值對：" + jedis.hdel("hash", "key2"));
        System.out.println("散列hash的所有键值對為：" + jedis.hgetAll("hash"));
        System.out.println("散列hash中键值對的個数：" + jedis.hlen("hash"));
        System.out.println("判斷hash中是否存在key2：" + jedis.hexists("hash", "key2"));
        System.out.println("判斷hash中是否存在key3：" + jedis.hexists("hash", "key3"));
        System.out.println("獲取hash中的值：" + jedis.hmget("hash", "key3"));
        System.out.println("獲取hash中的值：" + jedis.hmget("hash", "key3", "key4"));

        jedis.close();
    }
}
