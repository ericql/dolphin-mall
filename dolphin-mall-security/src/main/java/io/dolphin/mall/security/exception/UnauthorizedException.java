package io.dolphin.mall.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 9:26
 */
public class UnauthorizedException extends DolphinAuth2Exception {
    public UnauthorizedException(String msg) {
        super(msg);
    }


    public UnauthorizedException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "unauthorized";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

}
