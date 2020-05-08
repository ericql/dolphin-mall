package io.dolphin.mall.security.config;

import io.dolphin.mall.security.constants.SecurityConstants;
import io.dolphin.mall.security.util.DolphinTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

import java.util.Collections;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020/5/8 22:57
 */
@Configuration
public class TokenConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private TokenEnhancer tokenEnhancer;

    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix(SecurityConstants.DOLPHIN_OAUTH_PREFIX);
        return tokenStore;
    }


    @Primary
    @Bean
    @Lazy
    public AuthorizationServerTokenServices yamiTokenServices() {
        DolphinTokenServices tokenServices = new DolphinTokenServices();
        tokenServices.setTokenStore(tokenStore());
        //支持刷新token
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(true);
        tokenServices.setTokenEnhancer(tokenEnhancer);
        addUserDetailsService(tokenServices);
        return tokenServices;
    }

    private void addUserDetailsService(DolphinTokenServices tokenServices) {
        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(new UserDetailsByNameServiceWrapper<>(userDetailsService));
        tokenServices.setAuthenticationManager(new ProviderManager(Collections.singletonList(provider)));
    }
}
