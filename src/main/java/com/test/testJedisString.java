package com.test;

import org.json.JSONArray;
import org.json.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class testJedisString {
    public static void main(String[] args) {
        // 連接本地的 Redis 服務
        Jedis jedis = new Jedis("localhost");
        // 查看服務是否運行
        System.out.println("服務正在運行且連接成功: " + jedis.ping());

        System.out.println("==================一般字串資料=================");
        jedis.set("myKey", "Hello, Redis~");
        System.out.println("myKey is: " + jedis.get("myKey"));

        jedis.append("myKey", "安安你好");
        System.out.println("Append result: " + jedis.get("myKey"));
        System.out.println("myKey's length: " + jedis.strlen("myKey"));
        System.out.println("Get range: " + jedis.getrange("myKey", 7, 11));
        System.out.println("Get range(2): " + jedis.getrange("myKey", -18, -14));

        System.out.println("==================JSON格式=================");
        Pen myPen = new Pen(1, "SKB", 10);
        Pen yourPen = new Pen(2, "Pentel", 50);
        List<Pen> penList = new ArrayList<>();
        penList.add(myPen);
        penList.add(yourPen);

        String jObjStr = new JSONObject(myPen).toString();
        String jArrayStr = new JSONArray(penList).toString();
        StringBuilder sb = new StringBuilder("pen:").append(myPen.getId());
        jedis.set(sb.toString(), jObjStr);
        jedis.set("pens", jArrayStr);
        System.out.println(jedis.get(sb.toString()));
        System.out.println(jedis.get("pens"));

        System.out.println("==================多筆key處理=================");
        jedis.mset("key1", "value1", "key2", "value2", "key3", "value3");
        List<String> data = jedis.mget("key1", "key2", "key3");
        for (String str : data)
            System.out.println(str);

        jedis.close();
    }
}
