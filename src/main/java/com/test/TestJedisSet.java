package com.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author Bernice
 * 介绍在java中使用Jedis操作Redis的基本用法。
 * 集合set
 * 1.元素没有順序
 * 2.元素不可重複
 */
public class TestJedisSet {
    public static void main(String[] args) {
        // 連接本地的 Redis 服務
        Jedis jedis = new Jedis("localhost");
        // 查看服務是否運行
        System.out.println("服務正在運行且連接成功: " + jedis.ping());

        jedis.sadd("post:1:tags", "Java");
        jedis.sadd("post:2:tags", "Java", "Servlet");
        jedis.sadd("post:3:tags", "Java", "Servlet", "JSP");
        jedis.sadd("tag:Java:posts", "2", "1", "3");
        jedis.sadd("tag:Servlet:posts", "3", "2");
        jedis.sadd("tag:JSP:posts", "3");

        System.out.println("======印出post:3:tags的集合中所有元素=====");
        for (String str : jedis.smembers("post:3:tags")) {
            System.out.println(str);
        }

        System.out.println("============判斷某個元素是否存在於集合當中==========================");
        System.out.println(jedis.sismember("post:2:tags", "JSP"));

        System.out.println("============差集運算============================================");
        Set<String> diffResult = jedis.sdiff("post:2:tags", "post:1:tags");
        System.out.println(diffResult);

        System.out.println("============交集運算============================================");
        Set<String> interResult = jedis.sinter("tag:Java:posts", "tag:Servlet:posts", "tag:JSP:posts");
        System.out.println(interResult);

        System.out.println("============聯集運算============================================");

        Set<String> unionResult = jedis.sunion("post:1:tags", "post:2:tags", "post:3:tags");
        System.out.println(unionResult);

        System.out.println("============其它指令測試=========================================");

        System.out.println("============從集合中隨機獲取2個元素================================");
        jedis.sadd("candidate", "David", "Lai", "Aliee", "Hugh", "Ping Ru", "Chung-Yu");
        System.out.println(jedis.srandmember("candidate"));
        System.out.println("============從集合中隨機獲取List中3個元素。List<String>=============");
        System.out.println(jedis.srandmember("candidate", 3));

        jedis.close();
    }
}
