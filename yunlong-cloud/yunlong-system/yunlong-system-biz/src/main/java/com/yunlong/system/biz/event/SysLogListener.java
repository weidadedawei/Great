package com.yunlong.system.biz.event;

import com.yunlong.frame.log.dto.SysLogDTO;
import com.yunlong.frame.log.event.SaveSysLogEvent;
import com.yunlong.system.api.entity.SysLog;
import com.yunlong.system.biz.service.SysLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author david 异步监听日志事件
 */
@Slf4j
@AllArgsConstructor
@Component
public class SysLogListener {
    private final SysLogService sysLogService;

    @Async
    @Order
    @EventListener(SaveSysLogEvent.class)
    public void saveSysLog(SaveSysLogEvent event) {
        SysLogDTO sysLogDto = event.getSysLogDto();
        SysLog sysLog = new SysLog();
        BeanUtils.copyProperties(sysLogDto, sysLog);
        sysLogService.save(sysLog);
    }

}
