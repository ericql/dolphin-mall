package io.dolphin.common.config;

import io.dolphin.common.bean.ALiDaYu;
import io.dolphin.common.bean.Qiniu;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:05
 */
@Data
@Component
@PropertySource("classpath:mall.properties")
@ConfigurationProperties(prefix = "mall")
public class MallBasicConfig {
    /**
     * 七牛云的配置信息
     */
    private Qiniu qiniu;

    /**
     * 阿里大于短信平台
     */
    private ALiDaYu aLiDaYu;

    /**
     * 用于加解密token的密钥
     */
    private String tokenAesKey;
}
