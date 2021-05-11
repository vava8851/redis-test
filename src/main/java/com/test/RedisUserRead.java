package com.test;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author Bernice
 */
public class RedisUserRead {
    public static void main(String[] args) throws Exception {
        // 連接本地的 Redis 服務
        Jedis jedis = new Jedis("localhost");
        // 查看服務是否運行
        System.out.println("Redis服務正在運行且連接成功: " + jedis.ping());

        // 如果沒寫對應的db會取不出來!
        jedis.select(2);
        int start = 0;
        int end = -1;
        List<String> list = jedis.lrange("user", start, end);




        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表項目:" + list.get(i));
            System.out.println("列表項目:" + SerializeUtil.fromString(list.get(i)));
        }

        jedis.close();
    }

}
