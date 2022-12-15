package cn.yunlong.monitor.stream.channel;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 通道是队列的一种抽象，通道始终与目标队列名称关联，队列名称不会在代码中暴露，因此我们可以通过修改配置更改队列名称，而不是修改代码
 * @author aiot group
 * @date 2021/7/5 11:33 上午
 */
public interface PushMessageSinkChannel {

    /**
     * 输入通道名称
     */
    String INPUT = "input_push_message";

    @Input(PushMessageSinkChannel.INPUT)
    SubscribableChannel input();

}
