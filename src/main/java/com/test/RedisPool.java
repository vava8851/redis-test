package com.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost", 6379); // 建立連線池

        Jedis jedis = null;
        try {
            jedis = pool.getResource(); // 從連線池取得Jedis的實例
            jedis.set("foo", "bar");
            System.out.println(jedis.get("foo")); // bar
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        pool.close();

    }
}
