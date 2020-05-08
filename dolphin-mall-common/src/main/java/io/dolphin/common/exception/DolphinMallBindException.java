package io.dolphin.common.exception;

import io.dolphin.common.enums.DolphinHttpStatus;
import org.springframework.http.HttpStatus;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:00
 */
public class DolphinMallBindException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -4137688758944857209L;

    /**
     * http状态码
     */
    private Integer httpStatusCode;


    /**
     * @param httpStatus http状态码
     */
    public DolphinMallBindException(DolphinHttpStatus httpStatus) {
        super(httpStatus.getMsg());
        this.httpStatusCode = httpStatus.value();
    }

    /**
     * @param httpStatus http状态码
     */
    public DolphinMallBindException(DolphinHttpStatus httpStatus, String msg) {
        super(msg);
        this.httpStatusCode = httpStatus.value();
    }


    public DolphinMallBindException(String msg) {
        super(msg);
        this.httpStatusCode = HttpStatus.BAD_REQUEST.value();
    }


    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
