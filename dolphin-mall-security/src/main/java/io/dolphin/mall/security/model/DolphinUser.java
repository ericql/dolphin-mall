package io.dolphin.mall.security.model;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

/**
 * @Description: 用户详细信息
 * @Author: Eric Liang
 * @Since: 2020-5-9 15:38
 */
@Getter
public class DolphinUser extends User {
    /**
     * 用户ID
     */
    private String userId;

    private String bizUserId;

    @Setter
    private String pic;

    @Setter
    private String name;

    @Setter
    private boolean debugger;

    public DolphinUser(String userId, String bizUserId, Integer appId, boolean enabled) {
        super(appId + StrUtil.COLON + bizUserId, "", enabled,true, true, true , Collections.emptyList());
        this.userId = userId;
        this.bizUserId = bizUserId;
    }
}
