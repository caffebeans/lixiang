package com.lixiang.config;




import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/11/23
 **/
@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;
    // 定义一个或多个交换机
    public static final String PHONE_MESSAGE = "my-mq-PHONE_MESSAGE";
    // public static final String EXCHANGE_B = "my-mq-exchange_B";

    // 定义队列
    public static final String QUEUE_A = "QUEUE_A";
    // public static final String QUEUE_B = "QUEUE_B

    // 定义routing-key
    public static final String ROUTING_KEY_A = "spring-boot-routingKey_A";
    //  public static final String ROUTING_KEY_B = "spring-boot-routingKey_B";

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     **/
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(PHONE_MESSAGE);
    }

    /**
     * 获取队列A
     * @return
     */
    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirectQueue() {
        return new Queue("phoneCode_send",true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("PHONE_MESSAGE");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("");
    }








}
