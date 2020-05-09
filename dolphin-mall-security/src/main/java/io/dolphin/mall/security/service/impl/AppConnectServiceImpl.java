package io.dolphin.mall.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.dolphin.mall.security.dao.AppConnectMapper;
import io.dolphin.mall.security.enums.App;
import io.dolphin.mall.security.model.AppConnect;
import io.dolphin.mall.security.service.AppConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 17:27
 */
@Service
public class AppConnectServiceImpl extends ServiceImpl<AppConnectMapper, AppConnect> implements AppConnectService {
    @Autowired
    private AppConnectMapper appConnectMapper;

    /**
     * DolphinUserServiceImpl#insertUserIfNecessary 将会清楚该缓存信息
     * @param bizUserId
     * @param app
     * @return
     */
    @Override
    @Cacheable(cacheNames = "AppConnect", key = "#app.value() + ':' + #bizUserId")
    public AppConnect getByBizUserId(String bizUserId, App app) {
        return appConnectMapper.getByBizUserId(bizUserId, app.value());
    }
}
