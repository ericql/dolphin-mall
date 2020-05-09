package io.dolphin.mall.security.exception;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 9:25
 */
public class ImageCodeNotMatchExceptionBase extends BaseDolphinAuth2Exception {
    public ImageCodeNotMatchExceptionBase(String msg) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "image_code_not_match";
    }
}
