package io.dolphin.mall.security.service;

import io.dolphin.mall.security.enums.App;
import io.dolphin.mall.security.model.AppConnect;
import io.dolphin.mall.security.model.DolphinUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description: 用户详细信息
 * @Author: Eric Liang
 * @Since: 2020-5-9 15:40
 */
public interface DolphinUserDetailsService extends UserDetailsService {
    /**
     * 获取前端登陆的用户信息
     *
     * @param app 所登陆的应用
     * @param bizUserId openId
     * @return UserDetails
     */
    DolphinUser loadUserByAppIdAndBizUserId(App app, String bizUserId);

    /**
     * 如果必要的话，插入新增用户
     * @param appConnect
     */
    void insertUserIfNecessary(AppConnect appConnect);
}
