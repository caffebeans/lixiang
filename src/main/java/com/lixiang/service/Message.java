package com.lixiang.service;

/**
 * @description: 消息的顶级接口，只定义了消息的基本操作, 它的子类实现可能包括redis，rabbitmq,kafa等
 * @author: 张亮
 * @date: 2021/11/26
 **/
public interface Message <T>{

    boolean send(T t);
    T get();

}
