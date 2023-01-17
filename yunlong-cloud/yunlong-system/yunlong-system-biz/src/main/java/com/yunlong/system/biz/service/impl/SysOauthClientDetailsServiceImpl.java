package com.yunlong.system.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlong.system.api.entity.SysOauthClientDetails;
import com.yunlong.system.biz.mapper.SysOauthClientDetailsMapper;
import com.yunlong.system.biz.service.SysOauthClientDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 终端信息表(SysOauthClientDetails)服务实现类
 *
 * @author david
 * @date 2023-01-16 17:56:14
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, SysOauthClientDetails> implements SysOauthClientDetailsService {

}
