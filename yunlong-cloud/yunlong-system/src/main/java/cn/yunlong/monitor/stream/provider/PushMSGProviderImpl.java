package cn.yunlong.monitor.stream.provider;

import cn.yunlong.frame.stream.provider.IMessageProvider;
import cn.yunlong.monitor.stream.channel.PushMessageSourcesChannel;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @author sc
 * @date 2021/7/5 11:36 上午
 */
@EnableBinding(PushMessageSourcesChannel.class)
public class PushMSGProviderImpl implements IMessageProvider<JSONObject> {

    /**
     * 消息的发送管道
     */
    @Resource(name = PushMessageSourcesChannel.OUTPUT)
    private MessageChannel output;

    @Override
    public void sendMessage(JSONObject content) {
        // 创建并发送消息
        this.output.send(MessageBuilder.withPayload(content).build());
    }
}