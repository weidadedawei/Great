package cn.yunlong.frame.web.controller;

import cn.yunlong.frame.web.util.R;
import com.alibaba.fastjson2.util.DateUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * web基础控制器
 * @author sc
 * @date 2022/11/15 2:59 PM
 */
public class BaseController {

    /**
     * 获取 HttpServletRequest
     * Return HttpServletgetRequest(). Do not use HttpServletRequest Object in constructor of Controller
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取 HttpServletResponse
     * @return
     */
    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

//    /**
//     * 设置请求分页数据
//     */
//    protected void startPage() {
//        PageUtils.startPage();
//    }
//
//    /**
//     * 清理分页的线程变量
//     */
//    protected void clearPage() {
//        PageUtils.clearPage();
//    }
//
//    /**
//     * 响应请求分页数据
//     */
//    @SuppressWarnings({"rawtypes", "unchecked"})
//    protected TableDataInfo getDataTable(List<?> list) {
//        TableDataInfo rspData = new TableDataInfo();
//        rspData.setCode(HttpStatus.SUCCESS);
//        rspData.setRows(list);
//        rspData.setMsg("查询成功");
//        rspData.setTotal(new PageInfo(list).getTotal());
//        return rspData;
//    }

    /**
     * 返回成功
     */
    public R success() {
        return R.success();
    }

    /**
     * 返回成功消息
     */
    public R success(String message) {
        return R.success(message);
    }

    /**
     * 返回成功消息
     */
    public R success(Object data) {
        return R.success(data);
    }

    /**
     * 返回失败消息
     */
    public R error() {
        return R.failed();
    }

    /**
     * 返回失败消息
     */
    public R failed(String message) {
        return R.failed(message);
    }

//    /**
//     * 响应返回结果
//     *
//     * @param rows 影响行数
//     * @return 操作结果
//     */
//    protected AjaxResult toAjax(int rows) {
//        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
//    }
//
//    /**
//     * 响应返回结果
//     *
//     * @param result 结果
//     * @return 操作结果
//     */
//    protected AjaxResult toAjax(boolean result) {
//        return result ? success() : error();
//    }
}
