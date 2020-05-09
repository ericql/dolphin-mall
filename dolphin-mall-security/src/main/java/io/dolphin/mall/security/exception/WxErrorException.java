package io.dolphin.mall.security.exception;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 14:07
 */
public class WxErrorException extends DolphinAuth2Exception {
    public WxErrorException(String msg) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "wx_error_exception";
    }
}
