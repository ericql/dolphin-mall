package io.dolphin.mall.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 14:05
 */
public class UnknownGrantTypeExceptionBase extends BaseDolphinAuth2Exception {
    public UnknownGrantTypeExceptionBase(String msg) {
        super(msg);
    }


    public UnknownGrantTypeExceptionBase(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "unknown_grant_type";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

}
