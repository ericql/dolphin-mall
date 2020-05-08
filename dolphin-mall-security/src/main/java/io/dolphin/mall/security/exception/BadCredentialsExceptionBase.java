package io.dolphin.mall.security.exception;

/**
 * @Description: 密码不正确
 * @Author: Eric Liang
 * @Since: 2020/5/8 23:15
 */
public class BadCredentialsExceptionBase extends BaseDolphinAuth2Exception {
    public BadCredentialsExceptionBase(String msg) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "bad_credentials";
    }
}
