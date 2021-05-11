package com.test;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author user
 * 介绍在java中使用Jedis操作Redis的基本用法。
 * 陣列List。
 */
public class TestJedisList {
    public static void main(String[] args) {
        // 連接本地的 Redis 服務
        Jedis jedis = new Jedis("localhost");
        // 查看服務是否運行
        System.out.println("服務正在運行且連接成功: " + jedis.ping());

        System.out.println("=====================寫陣列List進Redis==============================");
        jedis.select(1);
        jedis.lpush("webSite-list", "Yahoo");
        jedis.lpush("webSite-list", "Google");
        jedis.lpush("webSite-list", "PcHome");
        // 把陣列讀出來
        int start = 0;
        int end = -1;
        List<String> list = jedis.lrange("webSite-list", start, end);
        for (String s : list) {
            System.out.println("陣列內容為" + s);
        }

        System.out.println("======Redis Lpop 命令用于移除并返回列表的第一个元素======================");
        if (jedis.exists("customers"))
            jedis.del("customers");

        jedis.lpush("customers", "David", "James", "Vincent", "Ben", "Ron", "George", "Howard");
        // List內容："Howard", "George", "Ron", "Ben", "Vincent", "James", "David"
        System.out.println(jedis.lpop("customers"));
        // List內容："George", "Ron", "Ben", "Vincent", "James", "David"
        jedis.rpush("customers", "Gakki", "Messi", "CR7");
        // List內容："George", "Ron", "Ben", "Vincent", "James", "David", "Gakki", "Messi", "CR7"

        System.out.println("========印出指定陣列元素==============================================");
        List<String> range1 = jedis.lrange("customers", 3, 6);
        for (String customer : range1)
            System.out.println(customer);

        System.out.println("========返回陣列長度==================================================");
        System.out.println("共有" + jedis.llen("customers") + "位客戶");

        System.out.println("======截取名稱為key的list，保留start至end之間的元素======================");
        //ltrim(key, start, end)
        jedis.ltrim("customers", 3, 6);
        List<String> range2 = jedis.lrange("customers", 0, jedis.llen("customers"));
        for (String customer : range2)
            System.out.println(customer);

        jedis.close();
    }
}
