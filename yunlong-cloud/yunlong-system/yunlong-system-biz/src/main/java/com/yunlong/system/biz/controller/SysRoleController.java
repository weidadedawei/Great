package com.yunlong.system.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.log.annotation.SysLog;
import com.yunlong.system.api.entity.SysRole;
import com.yunlong.system.biz.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 系统角色表(SysRole)控制层
 *
 * @author david
 * @date 2023-01-05 12:40:24
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysRole")
@Api(value = "sysRole", tags = "系统角色表")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param sysRole 系统角色表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R getSysRolePage(Page page, SysRole sysRole) {
        return R.success(sysRoleService.page(page, Wrappers.query(sysRole)));
    }

    /**
     * 通过id查询系统角色表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return R.success(sysRoleService.getById(id));
    }

    /**
     * 新增系统角色表
     *
     * @param sysRole 系统角色表
     * @return R
     */
    @ApiOperation(value = "新增系统角色表", notes = "新增系统角色表")
    @SysLog("新增系统角色表")
    @PostMapping
    public R save(@Valid @RequestBody SysRole sysRole) {
        return R.success(sysRoleService.save(sysRole));
    }

    /**
     * 修改系统角色表
     *
     * @param sysRole 系统角色表
     * @return R
     */
    @ApiOperation(value = "修改系统角色表", notes = "修改系统角色表")
    @SysLog("修改系统角色表")
    @PutMapping
    public R updateById(@Valid @RequestBody SysRole sysRole) {
        return R.success(sysRoleService.updateById(sysRole));
    }

    /**
     * 通过id删除系统角色表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除系统角色表", notes = "通过id删除系统角色表")
    @SysLog("通过id删除系统角色表")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Long id) {
        return R.success(sysRoleService.removeById(id));
    }

    /**
     * 导出excel 表格
     *
     * @param sysRole 查询条件
     * @return excel 文件流
     */
    //@ResponseExcel
    @GetMapping("/export")
    public List<SysRole> export(SysRole sysRole) {
        return sysRoleService.list(Wrappers.query(sysRole));
    }
}
