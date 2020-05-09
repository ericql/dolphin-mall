package io.dolphin.mall.security.token;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description: 二维码Token
 * @Author: Eric Liang
 * @Since: 2020-5-9 14:24
 */
public class MpAuthenticationToken extends MyAuthenticationToken {

    public MpAuthenticationToken(UserDetails principal, Object credentials) {
        super(principal, credentials, principal.getAuthorities());
    }
}
