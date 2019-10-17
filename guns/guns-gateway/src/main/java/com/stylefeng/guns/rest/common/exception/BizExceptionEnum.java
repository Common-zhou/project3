package com.stylefeng.guns.rest.common.exception;

import com.stylefeng.guns.core.exception.ServiceExceptionEnum;

/**
 * 所有业务异常的枚举
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:04:51
 */
public enum BizExceptionEnum implements ServiceExceptionEnum {

    /**
     * token异常
     */
    TOKEN_EXPIRED(700, "token过期"),
    TOKEN_ERROR(700, "token验证失败"),

    /**
     * 用户未登录
     */
    TOKEN_NOTFOUND(600,"用户未登录"),


    /**
     * 签名异常
     */
    SIGN_ERROR(700, "签名验证失败"),


    /**
     * 影片异常
     */
    FILM_EMPTY_EXCEPTION(1, "查询失败，无影片可加载"),

    /**
     * 系统出现异常
     */
    SYSTEM_EXCEPTION(999,"系统出现异常,请联系管理员"),

    /**
     * 其他
     */
    AUTH_REQUEST_ERROR(400, "账号密码错误");

    BizExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
