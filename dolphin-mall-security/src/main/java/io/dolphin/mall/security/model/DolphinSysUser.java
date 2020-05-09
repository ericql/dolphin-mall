package io.dolphin.mall.security.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Description: 用户详细信息
 * @Author: Eric Liang
 * @Since: 2020-5-9 17:23
 */
@Getter
@Setter
public class DolphinSysUser extends User {
    /**
     * 用户ID
     */
    @Getter
    private Long userId;

    /**
     * 租户ID
     */
    @Getter
    private Long shopId;

    public DolphinSysUser(Long userId, Long shopId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.shopId = shopId;
    }
}
