package io.dolphin.mall.security.util;

import io.dolphin.mall.security.exception.UnauthorizedExceptionBase;
import io.dolphin.mall.security.model.DolphinSysUser;
import io.dolphin.mall.security.model.DolphinUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Description: 安全工具类
 * @Author: Eric Liang
 * @Since: 2020-5-9 17:22
 */
@UtilityClass
public class SecurityUtils {
    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public DolphinUser getUser() {
        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof DolphinUser) {
            return (DolphinUser) principal;
        }
        throw new UnauthorizedExceptionBase("无法获取普通用户信息");
    }

    /**
     * 获取系统用户
     */
    public DolphinSysUser getSysUser() {
        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof DolphinSysUser) {
            return (DolphinSysUser) principal;
        }
        throw new UnauthorizedExceptionBase("无法获取系统用户信息");
    }
}
