package com.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestJedisTransaction {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");

        jedis.watch("pen:1");
        boolean isKeyExist = jedis.hexists("pen:1", "price");
        if (!isKeyExist) {
            Transaction tr = jedis.multi();
            tr.hset("pen:1", "price", "10");
            tr.exec();
            System.out.println("executed!");
        } else {
            jedis.unwatch();
            System.out.println("Unwatch key \"pen:1\"");
        }

        jedis.flushDB();
        jedis.close();
    }
}
