//package com.yunlong.system.biz.stream.channel;
//
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//
///**
// * 通道是队列的一种抽象，通道始终与目标队列名称关联，队列名称不会在代码中暴露，因此我们可以通过修改配置更改队列名称，而不是修改代码
// * @author aiot group
// * @date 2021/7/5 11:33 上午
// */
//public interface PushMessageSourcesChannel {
//
//    /**
//     * 输出通道名称
//     */
//    String OUTPUT = "output_push_message";
//
//    @Output(PushMessageSourcesChannel.OUTPUT)
//    MessageChannel output();
//
//}
