package io.dolphin.mall.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 9:31
 */
public class UnknownGrantTypeException extends DolphinAuth2Exception {
    public UnknownGrantTypeException(String msg) {
        super(msg);
    }


    public UnknownGrantTypeException(String msg, Throwable t) {
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
