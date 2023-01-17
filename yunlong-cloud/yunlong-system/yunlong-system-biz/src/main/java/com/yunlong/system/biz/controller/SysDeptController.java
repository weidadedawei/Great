package com.yunlong.system.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunlong.frame.core.util.R;
import com.yunlong.frame.log.annotation.SysLog;
import com.yunlong.system.api.entity.SysDept;
import com.yunlong.system.biz.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门管理(SysDept)控制层
 *
 * @author david
 * @date 2023-01-05 12:37:08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysDept")
@Api(value = "sysDept", tags = "部门管理")
public class SysDeptController {

    private final SysDeptService sysDeptService;

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param sysDept 部门管理
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R getSysDeptPage(Page page, SysDept sysDept) {
        return R.success(sysDeptService.page(page, Wrappers.query(sysDept)));
    }

    /**
     * 通过id查询部门管理
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id) {
        return R.success(sysDeptService.getById(id));
    }

    /**
     * 新增部门管理
     *
     * @param sysDept 部门管理
     * @return R
     */
    @ApiOperation(value = "新增部门管理", notes = "新增部门管理")
    @SysLog("新增部门管理")
    @PostMapping
    public R save(@Valid @RequestBody SysDept sysDept) {
        return R.success(sysDeptService.save(sysDept));
    }

    /**
     * 修改部门管理
     *
     * @param sysDept 部门管理
     * @return R
     */
    @ApiOperation(value = "修改部门管理", notes = "修改部门管理")
    @SysLog("修改部门管理")
    @PutMapping
    public R updateById(@Valid @RequestBody SysDept sysDept) {
        return R.success(sysDeptService.updateById(sysDept));
    }

    /**
     * 通过id删除部门管理
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除部门管理", notes = "通过id删除部门管理")
    @SysLog("通过id删除部门管理")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Long id) {
        return R.success(sysDeptService.removeById(id));
    }

    /**
     * 导出excel 表格
     *
     * @param sysDept 查询条件
     * @return excel 文件流
     */
    //@ResponseExcel
    @GetMapping("/export")
    public List<SysDept> export(SysDept sysDept) {
        return sysDeptService.list(Wrappers.query(sysDept));
    }
}
