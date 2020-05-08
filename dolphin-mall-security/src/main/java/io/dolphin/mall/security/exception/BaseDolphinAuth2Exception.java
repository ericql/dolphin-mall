package io.dolphin.mall.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020/5/8 23:14
 */
public abstract class BaseDolphinAuth2Exception  extends AuthenticationException {

    public BaseDolphinAuth2Exception(String msg) {
        super(msg);
    }

    public int getHttpErrorCode() {
        // 400 not 401
        return HttpStatus.BAD_REQUEST.value();
    }

    public abstract String getOAuth2ErrorCode();
}
