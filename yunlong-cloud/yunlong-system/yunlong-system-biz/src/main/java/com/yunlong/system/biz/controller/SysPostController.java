package com.yunlong.system.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.log.annotation.SysLog;
import com.yunlong.system.api.entity.SysPost;
import com.yunlong.system.biz.service.SysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 岗位信息表(SysPost)控制层
 *
 * @author david
 * @date 2023-01-05 12:40:03
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysPost")
@Api(value = "sysPost", tags = "岗位信息表")
public class SysPostController {

    private final SysPostService sysPostService;

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param sysPost 岗位信息表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R getSysPostPage(Page page, SysPost sysPost) {
        return R.success(sysPostService.page(page, Wrappers.query(sysPost)));
    }

    /**
     * 通过id查询岗位信息表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return R.success(sysPostService.getById(id));
    }

    /**
     * 新增岗位信息表
     *
     * @param sysPost 岗位信息表
     * @return R
     */
    @ApiOperation(value = "新增岗位信息表", notes = "新增岗位信息表")
    @SysLog("新增岗位信息表")
    @PostMapping
    public R save(@Valid @RequestBody SysPost sysPost) {
        return R.success(sysPostService.save(sysPost));
    }

    /**
     * 修改岗位信息表
     *
     * @param sysPost 岗位信息表
     * @return R
     */
    @ApiOperation(value = "修改岗位信息表", notes = "修改岗位信息表")
    @SysLog("修改岗位信息表")
    @PutMapping
    public R updateById(@Valid @RequestBody SysPost sysPost) {
        return R.success(sysPostService.updateById(sysPost));
    }

    /**
     * 通过id删除岗位信息表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除岗位信息表", notes = "通过id删除岗位信息表")
    @SysLog("通过id删除岗位信息表")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Long id) {
        return R.success(sysPostService.removeById(id));
    }

    /**
     * 导出excel 表格
     *
     * @param sysPost 查询条件
     * @return excel 文件流
     */
    //@ResponseExcel
    @GetMapping("/export")
    public List<SysPost> export(SysPost sysPost) {
        return sysPostService.list(Wrappers.query(sysPost));
    }
}
