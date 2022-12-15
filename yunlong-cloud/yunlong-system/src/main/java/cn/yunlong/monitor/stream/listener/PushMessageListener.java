package cn.yunlong.monitor.stream.listener;

import cn.yunlong.frame.stream.listener.IMessageListener;
import cn.yunlong.monitor.stream.channel.PushMessageSinkChannel;
import com.alibaba.fastjson2.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: sc
 * @date: 2022/11/18 16:53
 * @version: V1.0
 */
@Component
@EnableBinding(PushMessageSinkChannel.class)
@Slf4j
public class PushMessageListener implements IMessageListener<JSONObject> {

    @SneakyThrows
    @StreamListener(PushMessageSinkChannel.INPUT)
    @Override
    public void input(Message<JSONObject> message) {
        log.debug("【*** 消息接收 ***】" + message.getPayload());
    }
}