package com.yunlong.system.biz.mapper;

import com.yunlong.frame.mybatis.base.BaseMapperX;
import com.yunlong.system.api.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author david
 * @date 2023-01-02 20:03:03
 */
@Mapper
public interface SysUserMapper extends BaseMapperX<SysUser> {

}
