package com.yunlong.frame.stream.provider;

/**
 * 消息提供者接口
 *
 * @author sc
 * @date 2022/11/18 10:55 上午
 */
public interface IMessageProvider<T> {

    /**
     * 发送消息
     *
     * @param content
     */
    void sendMessage(T content);

}
