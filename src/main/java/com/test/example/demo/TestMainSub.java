package com.test.example.demo;

import com.test.Publisher;
import com.test.Subscriber;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestMainSub {
    public static void main(String[] args) {
        // 連接redis服務端
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);

        Publisher publisher = new Publisher(jedisPool);    //發布者
        publisher.start();

        Subscriber subscriber = new Subscriber(jedisPool);    //訂閱者
        subscriber.start();
    }
}
