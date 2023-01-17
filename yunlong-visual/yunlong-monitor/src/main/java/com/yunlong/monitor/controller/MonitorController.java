package com.yunlong.monitor.controller;

import com.yunlong.frame.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sc
 * @date 2022/11/15 10:36 AM
 */
@RestController
@RequestMapping("/jasypt")
@Api(tags = "监听控制层")
public class MonitorController {
    @Autowired
    private StringEncryptor encryptor;

    /**
     * 加密
     *
     * @param obj
     * @return
     */
    @PostMapping("/encrypt")
    @ApiOperation(value = "监听1", httpMethod = "POST")
    public R encrypt(@RequestBody JSONObject obj) throws JSONException {
        String plaintext = obj.getString("plaintext");
        return R.success(encryptor.encrypt(plaintext));
    }


    /**
     * 解密
     *
     * @param obj
     * @return
     */
    @PostMapping("/decrypt")
    @ApiOperation(value = "监听1222", httpMethod = "POST")
    public R decrypt(@RequestBody JSONObject obj) throws JSONException {
        String ciphertext = obj.getString("ciphertext");
        return R.success(encryptor.decrypt(ciphertext));
    }

}
