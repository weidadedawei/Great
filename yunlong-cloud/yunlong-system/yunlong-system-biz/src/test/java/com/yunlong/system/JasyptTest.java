package com.yunlong.system;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sc
 * @date 2022/11/15 10:26 AM
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {

    @Autowired
    private StringEncryptor encryptor;
    @Value("${spring.application.name}")
//    @NacosValue("${spring.application.name}")
    private String applicationName;

    @Test
    public void encode() {
        String applicationName = "demo-application";
        System.out.println(encryptor.encrypt(applicationName));
    }

    @Test
    public void print() {
        System.out.println(applicationName);
    }

}