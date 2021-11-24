package com.lixiang.handler;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:  用于接收来自rabbitmq消息中间件的数据,可用于发送短信
 * @author: 张亮
 * @date: 2021/11/24
 **/


@Component
public class RabbitPhoneNumberHandle {

    @RabbitHandler
    @RabbitListener(queues = "phoneCode_send")//监听的队列名称 TestDirectQueue
    public void process(String s) {
        System.out.println("DirectReceiver消费者收到消息 "+s);

    }


}