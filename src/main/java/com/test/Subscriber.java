package com.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Subscriber extends Thread {
    private final JedisPool jedisPool;
    private final MsgListener msgListener = new MsgListener();

    private final String channel = "mychannel";

    public Subscriber(JedisPool jedisPool) {
        super("Subscriber");
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();   //取出一个連線
            jedis.subscribe(msgListener, channel);    //通過subscribe的api去訂閱，參數是訂閱者和頻道名

            //注意：subscribe是一個阻塞的方法，在取消訂閱該頻道前，會一直阻塞在這，無法執行會後續的Code
            //這裡在msgListener的onMessage方法裡面收到消息後，調用了this.unsubscribe();来取消訂閱，才會繼續執行
            System.out.println("繼續執行後續代碼....");

        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
