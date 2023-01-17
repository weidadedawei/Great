package com.yunlong.system.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.pig4cloud.plugin.excel.annotation.ResponseExcel;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.log.annotation.SysLog;
import com.yunlong.system.api.entity.SysOauthClientDetails;
import com.yunlong.system.biz.service.SysOauthClientDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 终端信息表(SysOauthClientDetails)控制层
 *
 * @author david
 * @date 2023-01-16 17:56:14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysOauthClientDetails")
@Api(value = "sysOauthClientDetails", tags = "终端信息表")
public class SysOauthClientDetailsController {

    private final SysOauthClientDetailsService sysOauthClientDetailsService;

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param sysOauthClientDetails 终端信息表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R getSysOauthClientDetailsPage(Page page, SysOauthClientDetails sysOauthClientDetails) {
        return R.success(sysOauthClientDetailsService.page(page, Wrappers.query(sysOauthClientDetails)));
    }

    /**
     * 通过id查询终端信息表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return R.success(sysOauthClientDetailsService.getById(id));
    }

    /**
     * 新增终端信息表
     *
     * @param sysOauthClientDetails 终端信息表
     * @return R
     */
    @ApiOperation(value = "新增终端信息表", notes = "新增终端信息表")
    @SysLog("新增终端信息表")
    @PostMapping
    public R save(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
        return R.success(sysOauthClientDetailsService.save(sysOauthClientDetails));
    }

    /**
     * 修改终端信息表
     *
     * @param sysOauthClientDetails 终端信息表
     * @return R
     */
    @ApiOperation(value = "修改终端信息表", notes = "修改终端信息表")
    @SysLog("修改终端信息表")
    @PutMapping
    public R updateById(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
        return R.success(sysOauthClientDetailsService.updateById(sysOauthClientDetails));
    }

    /**
     * 通过id删除终端信息表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除终端信息表", notes = "通过id删除终端信息表")
    @SysLog("通过id删除终端信息表")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Long id) {
        return R.success(sysOauthClientDetailsService.removeById(id));
    }

    /**
     * 导出excel 表格
     *
     * @param sysOauthClientDetails 查询条件
     * @return excel 文件流
     */
    //@ResponseExcel
    @GetMapping("/export")
    public List<SysOauthClientDetails> export(SysOauthClientDetails sysOauthClientDetails) {
        return sysOauthClientDetailsService.list(Wrappers.query(sysOauthClientDetails));
    }

    /**
     * 根据clientId查询终端信息
     * @param clientId
     * @return
     */
//    @Inner(false)
    @GetMapping("/getClientDetailsById/{clientId}")
    public R getClientDetailsById(@PathVariable String clientId) {
        return R.success(sysOauthClientDetailsService.getOne(
                Wrappers.<SysOauthClientDetails>lambdaQuery().eq(SysOauthClientDetails::getClientId, clientId), false));
    }

    /**
     * 查询全部客户端
     * @return
     */
//    @Inner(false)
    @GetMapping("/list")
    public R listClients() {
        return R.success(sysOauthClientDetailsService.list());
    }
}
