package cn.yunlong.monitor.controller;

import cn.yunlong.frame.web.controller.BaseController;
import cn.yunlong.frame.web.util.R;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sc
 * @date 2022/11/15 10:36 AM
 */
@RestController
@RequestMapping("/jasypt")
@Api(tags = "监听控制层")
public class MonitorController extends BaseController {
    @Autowired
    private StringEncryptor encryptor;

    /**
     * 加密
     * @param obj
     * @return
     */
    @PostMapping("/encrypt")
    @ApiOperation(value = "监听1", httpMethod = "POST")
    public R encrypt(@RequestBody JSONObject obj) {
        String plaintext = obj.getString("plaintext");
        return success(encryptor.encrypt(plaintext));
    }


    /**
     * 解密
     * @param obj
     * @return
     */
    @PostMapping("/decrypt")
    @ApiOperation(value = "监听1222", httpMethod = "POST")
    public R decrypt(@RequestBody JSONObject obj) {
        String ciphertext = obj.getString("ciphertext");
        return success(encryptor.decrypt(ciphertext));
    }

}
