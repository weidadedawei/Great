package com.yunlong.system.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunlong.system.api.entity.SysUserPost;
import com.yunlong.system.biz.mapper.SysUserPostMapper;
import com.yunlong.system.biz.service.SysUserPostService;
import org.springframework.stereotype.Service;

/**
 * 用户与岗位关联表(SysUserPost)服务实现类
 *
 * @author david
 * @date 2023-01-05 12:41:11
 */
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost> implements SysUserPostService {

}
