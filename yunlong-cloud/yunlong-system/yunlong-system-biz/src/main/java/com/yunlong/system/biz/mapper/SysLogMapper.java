package com.yunlong.system.biz.mapper;

import com.yunlong.frame.mybatis.base.BaseMapperX;
import com.yunlong.system.api.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志表(SysLog)表数据库访问层
 *
 * @author david
 * @date 2023-01-04 17:30:24
 */
@Mapper
public interface SysLogMapper extends BaseMapperX<SysLog> {

}
