package com.yunlong.frame.mybatis.handler;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yunlong.frame.web.util.WebFrameworkUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.ClassUtils;

import java.nio.charset.Charset;

/**
 * 通用参数填充实现类
 * <p>
 * 如果没有显式的对通用参数进行赋值，这里会对通用参数进行填充、赋值
 *
 * @author hexiaowu
 */
public class YunLongDBFieldHandler implements MetaObjectHandler {

    /**
     * 填充值，先判断是否有手动设置，优先手动设置的值，例如：job必须手动设置
     *
     * @param fieldName  属性名
     * @param fieldVal   属性值
     * @param metaObject MetaObject
     * @param isCover    是否覆盖原有值,避免更新操作手动入参
     */
    private static void fillValIfNullByName(String fieldName, Object fieldVal, MetaObject metaObject, boolean isCover) {
        // 0. 如果填充值为空
        if (fieldVal == null) {
            return;
        }
        // 1. 没有 get 方法
        if (!metaObject.hasSetter(fieldName)) {
            return;
        }
        // 2. 如果用户有手动设置的值
        Object userSetValue = metaObject.getValue(fieldName);
        String setValueStr = StrUtil.str(userSetValue, Charset.defaultCharset());
        if (StrUtil.isNotBlank(setValueStr) && !isCover) {
            return;
        }
        // 3. field 类型相同时设置
        Class<?> getterType = metaObject.getGetterType(fieldName);
        if (ClassUtils.isAssignableValue(getterType, fieldVal)) {
            metaObject.setValue(fieldName, fieldVal);
        }
    }

    /**
     * 插入时填充
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = WebFrameworkUtils.getLoginUserId();
        // 当前登录用户不为空，创建人为空，则当前登录用户为创建人
        fillValIfNullByName("creator", userId, metaObject, false);
        // 当前登录用户不为空，更新人为空，则当前登录用户为更新人
        fillValIfNullByName("updater", userId, metaObject, false);
    }

    /**
     * 更新时填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 当前登录用户不为空，更新人为空，则当前登录用户为更新人
        Long userId = WebFrameworkUtils.getLoginUserId();
        fillValIfNullByName("updater", userId, metaObject, false);
    }
}
