package io.dolphin.mall.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.dolphin.mall.security.enums.App;
import io.dolphin.mall.security.model.AppConnect;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 17:25
 */
public interface AppConnectService extends IService<AppConnect> {
    AppConnect getByBizUserId(String bizUserId, App app);
}
