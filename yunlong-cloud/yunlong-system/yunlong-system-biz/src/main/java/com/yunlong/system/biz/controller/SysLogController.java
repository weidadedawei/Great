package com.yunlong.system.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunlong.frame.core.util.R;
import com.yunlong.system.api.entity.SysLog;
import com.yunlong.system.biz.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 日志表(SysLog)控制层
 *
 * @author david
 * @date 2023-01-04 17:30:21
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysLog")
@Api(value = "sysLog", tags = "日志表")
public class SysLogController {

    private final SysLogService sysLogService;

    /**
     * 分页查询
     *
     * @param page   分页对象
     * @param sysLog 日志表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R getSysLogPage(Page page, SysLog sysLog) {
        return R.success(sysLogService.page(page, Wrappers.query(sysLog)));
    }

    /**
     * 通过id查询日志表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return R.success(sysLogService.getById(id));
    }

    /**
     * 新增日志表
     *
     * @param sysLog 日志表
     * @return R
     */
    @ApiOperation(value = "新增日志表", notes = "新增日志表")
    @com.yunlong.frame.log.annotation.SysLog("新增日志表")
    @PostMapping
    public R save(@Valid @RequestBody SysLog sysLog) {
        return R.success(sysLogService.save(sysLog));
    }

    /**
     * 修改日志表
     *
     * @param sysLog 日志表
     * @return R
     */
    @ApiOperation(value = "修改日志表", notes = "修改日志表")
    @com.yunlong.frame.log.annotation.SysLog("修改日志表")
    @PutMapping
    public R updateById(@Valid @RequestBody SysLog sysLog) {
        return R.success(sysLogService.updateById(sysLog));
    }

    /**
     * 通过id删除日志表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除日志表", notes = "通过id删除日志表")
    @com.yunlong.frame.log.annotation.SysLog("通过id删除日志表")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Long id) {
        return R.success(sysLogService.removeById(id));
    }

    /**
     * 导出excel 表格
     *
     * @param sysLog 查询条件
     * @return excel 文件流
     */
    //@ResponseExcel
    @GetMapping("/export")
    public List<SysLog> export(SysLog sysLog) {
        return sysLogService.list(Wrappers.query(sysLog));
    }
}
