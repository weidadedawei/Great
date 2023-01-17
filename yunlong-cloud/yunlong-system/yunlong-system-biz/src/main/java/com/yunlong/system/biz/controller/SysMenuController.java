package com.yunlong.system.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.log.annotation.SysLog;
import com.yunlong.system.api.entity.SysMenu;
import com.yunlong.system.biz.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 菜单权限表(SysMenu)控制层
 *
 * @author david
 * @date 2023-01-05 12:39:39
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysMenu")
@Api(value = "sysMenu", tags = "菜单权限表")
public class SysMenuController {

    private final SysMenuService sysMenuService;

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param sysMenu 菜单权限表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R getSysMenuPage(Page page, SysMenu sysMenu) {
        return R.success(sysMenuService.page(page, Wrappers.query(sysMenu)));
    }

    /**
     * 通过id查询菜单权限表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return R.success(sysMenuService.getById(id));
    }

    /**
     * 新增菜单权限表
     *
     * @param sysMenu 菜单权限表
     * @return R
     */
    @ApiOperation(value = "新增菜单权限表", notes = "新增菜单权限表")
    @SysLog("新增菜单权限表")
    @PostMapping
    public R save(@Valid @RequestBody SysMenu sysMenu) {
        return R.success(sysMenuService.save(sysMenu));
    }

    /**
     * 修改菜单权限表
     *
     * @param sysMenu 菜单权限表
     * @return R
     */
    @ApiOperation(value = "修改菜单权限表", notes = "修改菜单权限表")
    @SysLog("修改菜单权限表")
    @PutMapping
    public R updateById(@Valid @RequestBody SysMenu sysMenu) {
        return R.success(sysMenuService.updateById(sysMenu));
    }

    /**
     * 通过id删除菜单权限表
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除菜单权限表", notes = "通过id删除菜单权限表")
    @SysLog("通过id删除菜单权限表")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Long id) {
        return R.success(sysMenuService.removeById(id));
    }

    /**
     * 导出excel 表格
     *
     * @param sysMenu 查询条件
     * @return excel 文件流
     */
    //@ResponseExcel
    @GetMapping("/export")
    public List<SysMenu> export(SysMenu sysMenu) {
        return sysMenuService.list(Wrappers.query(sysMenu));
    }
}
