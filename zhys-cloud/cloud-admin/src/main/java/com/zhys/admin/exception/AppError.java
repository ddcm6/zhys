package com.zhys.admin.exception;

import com.zhys.common.exception.IError;

/**
 * 说明：服务治理app异常
 * @Author: diandian
 * @date: 17:48 2019/5/9
 */
public enum AppError implements IError {
    /**
     * 服务不存在
     */
    SERVER_ISNOT_EXIST("0001","server is not exist"),
    ;

    String errorCode;
    String errorMessage;
    private final String nameSpace = "ZHYS-ADMIN";

    AppError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getNameSpace() {
        return nameSpace;
    }

    @Override
    public String getErrorCode() {
        return nameSpace + "." + this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
