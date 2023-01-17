//package com.yunlong.system.biz.controller;
//
//import com.yunlong.system.biz.stream.provider.PushMSGProviderImpl;
//import com.yunlong.frame.core.util.R;
//import com.alibaba.fastjson2.JSONObject;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author sc
// * @date 2022/11/15 10:36 AM
// */
//@RestController
//@RequestMapping("/stream")
//@Api(tags = "消息流")
//public class StreamController {
//
//    @Autowired
//    private PushMSGProviderImpl pushMSGProviderImpl;
//
//    /**
//     * 发送
//     * @param obj
//     * @return
//     */
//    @PostMapping("/send")
//    @ApiOperation(value = "发送", httpMethod = "POST")
//    public R send(@RequestBody JSONObject obj) {
//        pushMSGProviderImpl.sendMessage(obj);
//        return success();
//    }
//}
