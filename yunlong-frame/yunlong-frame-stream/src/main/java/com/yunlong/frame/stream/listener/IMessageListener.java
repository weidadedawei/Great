package com.yunlong.frame.stream.listener;

import org.springframework.messaging.Message;

/**
 * 默认消息监听接口
 *
 * @author sc
 * @date 2022/11/18 10:55 上午
 */
public interface IMessageListener<T> {

    /**
     * 监听处理消息
     *
     * @param message
     */
    void input(Message<T> message);

}