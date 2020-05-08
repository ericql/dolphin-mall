package io.dolphin.mall.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020/5/8 23:09
 */
public abstract class DolphinAuth2Exception extends AuthenticationException {

    public DolphinAuth2Exception(String msg) {
        super(msg);
    }

    public int getHttpErrorCode() {
        // 400 not 401
        return HttpStatus.BAD_REQUEST.value();
    }

    public abstract String getOAuth2ErrorCode();
}
