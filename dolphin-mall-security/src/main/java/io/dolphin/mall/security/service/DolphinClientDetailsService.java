package io.dolphin.mall.security.service;

import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @Description: 获取客户端
 * @Author: Eric Liang
 * @Since: 2020-5-9 17:35
 */
public class DolphinClientDetailsService extends JdbcClientDetailsService {

    public DolphinClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }
}
