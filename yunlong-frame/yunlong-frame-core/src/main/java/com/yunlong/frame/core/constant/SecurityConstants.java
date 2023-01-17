package com.yunlong.frame.core.constant;

/**
 * @author david
 * @date 2023-1-17
 */
public interface SecurityConstants {

    /**
     * 启动时是否检查Inner注解安全性
     */
    boolean INNER_CHECK = true;

    /**
     * 刷新
     */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * 验证码有效期
     */
    int CODE_TIME = 60;

    /**
     * 验证码长度
     */
    String CODE_SIZE = "4";

    /**
     * 角色前缀
     */
    String ROLE = "ROLE_";

    /**
     * 前缀
     */
    String PIGX_PREFIX = "pigx_";

    /**
     * token 相关前缀
     */
    String TOKEN_PREFIX = "token:";

    /**
     * oauth 相关前缀
     */
    String OAUTH_PREFIX = "oauth:";

    /**
     * 授权码模式code key 前缀
     */
    String OAUTH_CODE_PREFIX = "oauth:code:";

    /**
     * 内部
     */
    String FROM_IN = "Y";

    /**
     * 标志
     */
    String FROM = "from";

    /**
     * OAUTH URL
     */
    String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * {bcrypt} 加密的特征码
     */
    String BCRYPT = "{bcrypt}";

}
