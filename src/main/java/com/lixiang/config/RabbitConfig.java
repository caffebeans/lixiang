package com.lixiang.config;


import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @description: 完成rabbitmq的相关配置，大概的步骤是
 * 1：创建一个交换机（给出相关的类型名）
 * 2：创建相应的队列，给出队列的名称（可以创建多个队列）
 * 3. 完成交换机与路由之间的邦定
 * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
 * HeadersExchange ：通过添加属性key-value匹配
 * DirectExchange:按照routingkey分发到指定队列
 * TopicExchange:多关键字匹配
 * @author: 张亮
 * @date: 2021/11/23
 **/
@Configuration
@Slf4j
public class RabbitConfig {

    // 定义一个或多个交换机
    public static final String PHONE_MESSAGE = "my-mq-PHONE_MESSAGE";
    // public static final String EXCHANGE_B = "my-mq-exchange_B";


    @Autowired
    RabbitTemplate rabbitTemplate;


    @PostConstruct
    public void setCallback() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if (b){
                    log.info("消息投递到交换机成功：[correlationData={}]",correlationData);
                }else {
                    log.info("消息投递失败");
                }
            }
        });
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     **/
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(PHONE_MESSAGE);
    }

    /**
     * @des:创建一个fantout类型的交换机，没有多余的参数，直接进行路由即可
     */

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("MESSAGE_FANOUT");
    }

    @Bean
    public Queue TestDirectQueue() {
        return new Queue("phoneCode_send", true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("PHONE_MESSAGE");
    }

    /**
     * @des: 用于发送验证码
     * @return
     */
    @Bean
    Queue phoneNumberCode(){
        return new Queue("phoneCode");
    }


    @Bean
    Binding bindingPhoneNumCode(){
        return BindingBuilder.bind(phoneNumberCode()).to(fanoutExchange());
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("");
    }


}
