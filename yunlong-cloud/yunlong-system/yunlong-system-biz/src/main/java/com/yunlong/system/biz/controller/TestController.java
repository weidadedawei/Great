package com.yunlong.system.biz.controller;

import com.yunlong.frame.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/init")
    @PreAuthorize("hasAuthority('p1')")
    public R init() {
        return R.success();
    }

}