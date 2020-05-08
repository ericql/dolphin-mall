package io.dolphin.common.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:09
 */
@Data
public class ServerResponse<T> implements Serializable {

    private int code;

    private String msg;

    private T obj;

    public boolean isSuccess(){
        return Objects.equals(ResponseCode.SUCCESS, this.code);
    }
}
