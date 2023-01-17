package com.yunlong.system.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlong.system.api.entity.SysLog;
import com.yunlong.system.biz.mapper.SysLogMapper;
import com.yunlong.system.biz.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * 日志表(SysLog)服务实现类
 *
 * @author david
 * @date 2023-01-04 17:30:23
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
