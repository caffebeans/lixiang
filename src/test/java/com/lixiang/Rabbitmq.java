package com.lixiang;


import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannelImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
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


public class Rabbitmq extends LixiangApplicationTests {


    @Test
    void connetctionBuild() throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("110.40.158.79");
        factory.setUsername("root");
        factory.setPassword("zhangliang2012");
        Connection connection = factory.newConnection();


        String message = "hellow world+0000001111111";
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("pulbic","fanout");


        Map<String, Object> argss = new HashMap<>();
        argss.put("x-message-ttl",60000);

        // channel.queueDeclare("q1",false,false,false,argss);


        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        builder.expiration("60000");
        for (int i = 0; i < 100; i++) {

            channel.basicPublish("public","q1",builder.build(),message.getBytes());
        }




    }


}

class ShutDownListener implements ShutdownListener {

    @Override
    public void shutdownCompleted(ShutdownSignalException e) {
        System.out.println(toString()+"连接关闭--");
    }
}


