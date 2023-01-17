package com.yunlong.system.biz.mapper;

import com.yunlong.frame.mybatis.base.BaseMapperX;
import com.yunlong.system.api.entity.SysUserPost;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与岗位关联表(SysUserPost)表数据库访问层
 *
 * @author david
 * @date 2023-01-05 12:41:11
 */
@Mapper
public interface SysUserPostMapper extends BaseMapperX<SysUserPost> {

}
