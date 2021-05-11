package com.test;

import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @author Bernice
 * 存成object時，有3個方法
 * 1.把user轉成json，再用字串方式存進去
 * 2.透過序列化
 * 3.把這物件轉成base64字串存進去變成說存進去就是字串
 */
public class RedisUserWrite {
    public static void main(String[] args) throws IOException {
        // 連接本地的 Redis 服務
        Jedis jedis = new Jedis("localhost");
        // 查看服務是否運行
        System.out.println("Redis服務正在運行且連接成功: " + jedis.ping());

        jedis.select(2);
        jedis.lpush("user", SerializeUtil.toString(new User(100,"張三","123")));
        jedis.lpush("user", SerializeUtil.toString(new User(101,"李四","456")));
        jedis.lpush("user", SerializeUtil.toString(new User(102,"王五","789")));

        jedis.close();
    }
}
