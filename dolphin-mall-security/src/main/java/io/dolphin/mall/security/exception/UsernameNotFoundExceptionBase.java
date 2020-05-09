package io.dolphin.mall.security.exception;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 14:06
 */
public class UsernameNotFoundExceptionBase extends BaseDolphinAuth2Exception {
    public UsernameNotFoundExceptionBase(String msg) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "username_not_found";
    }
}
