package io.dolphin.common.config;

import cn.hutool.crypto.symmetric.AES;
import io.dolphin.common.bean.ALiDaYu;
import io.dolphin.common.bean.Qiniu;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:06
 */
@Configuration
@AllArgsConstructor
public class MallBeanConfig {
    private final MallBasicConfig mallBasicConfig;

    @Bean
    public Qiniu qiniu() {
        return mallBasicConfig.getQiniu();
    }

    @Bean
    public AES tokenAes() {
        return new AES(mallBasicConfig.getTokenAesKey().getBytes());
    }

    @Bean
    public ALiDaYu aLiDaYu () {
        return mallBasicConfig.getALiDaYu();
    }
}
