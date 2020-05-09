package io.dolphin.mall.security.provider;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-9 14:21
 */
public interface AuthenticationTokenParser {
    AbstractAuthenticationToken parse(String authenticationTokenStr);
}
