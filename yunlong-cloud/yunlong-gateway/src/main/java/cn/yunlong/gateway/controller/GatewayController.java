//package cn.yunlong.gateway.controller;
//
//import com.alibaba.fastjson2.JSONObject;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.jasypt.encryption.StringEncryptor;
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
//@RequestMapping("/gateway")
//@Api(tags = "网关控制层")
//public class GatewayController {
//    @Autowired
//    private StringEncryptor encryptor;
//
//    /**
//     * 加密
//     *
//     * @param obj
//     * @return
//     */
//    @PostMapping("/encrypt")
//    @ApiOperation(value = "加密", httpMethod = "POST")
//    public String encrypt(@RequestBody JSONObject obj) {
//        String plaintext = obj.getString("plaintext");
//        return encryptor.encrypt(plaintext);
//    }
//
//
//    /**
//     * 解密
//     *
//     * @param obj
//     * @return
//     */
//    @PostMapping("/decrypt")
//    @ApiOperation(value = "解密", httpMethod = "POST")
//    public String decrypt(@RequestBody JSONObject obj) {
//        String ciphertext = obj.getString("ciphertext");
//        return encryptor.decrypt(ciphertext);
//    }
//
//}