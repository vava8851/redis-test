package com.test;

import redis.clients.jedis.JedisPubSub;

public class MsgListener extends JedisPubSub {

    public MsgListener() {
    }

    @Override
    public void onMessage(String channel, String message) {       //收到消息會調用
        System.out.println(String.format("收到消息成功！ channel： %s, message： %s", channel, message));
        this.unsubscribe();
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {    //訂閱頻道會調用
        System.out.println(String.format("訂閱頻道成功！ channel： %s, subscribedChannels %d",
            channel, subscribedChannels));
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {   //取消訂閱會調用
        System.out.println(String.format("取消訂閱頻道！ channel： %s, subscribedChannels： %d",
            channel, subscribedChannels));

    }
}