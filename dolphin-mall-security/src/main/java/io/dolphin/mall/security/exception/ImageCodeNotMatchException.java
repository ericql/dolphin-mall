package io.dolphin.mall.security.exception;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 8:21
 */
public class ImageCodeNotMatchException extends DolphinAuth2Exception {
    public ImageCodeNotMatchException(String msg) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "image_code_not_match";
    }
}
