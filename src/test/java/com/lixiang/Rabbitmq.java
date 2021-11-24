package com.lixiang;


import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannelImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/11/23
 **/


public class Rabbitmq  extends LixiangApplicationTests{

    // 创建连接工厂,获取MQ的连接
    @Autowired
    private RabbitTemplate rabbitTemplate;



    @Test
    public void sendMessage() {

        for (int i = 0; i <1000 ; i++) {

            rabbitTemplate.convertAndSend("q1","hello"+i);
        }
    }




}


