package com.yunlong.frame.log.event;

import com.yunlong.frame.log.dto.SysLogDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author david 保存系统日志事件
 */
@Getter
@AllArgsConstructor
public class SaveSysLogEvent {

    private final SysLogDTO sysLogDto;

}
