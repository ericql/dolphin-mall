package io.dolphin.mall.security.controller;

import io.dolphin.common.util.RedisUtil;
import io.dolphin.common.util.SimpleCaptcha;
import io.dolphin.mall.security.constants.SecurityConstants;
import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 登录相关
 * @Author: Eric Liang
 * @Since: 2020/5/8 23:04
 */
@Controller
@AllArgsConstructor
@ApiIgnore
public class LoginController {
    private final CacheManager cacheManager;


    @GetMapping("/captcha.jpg")
    public void login(HttpServletResponse response, String uuid) {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        SimpleCaptcha simpleCaptcha = new SimpleCaptcha(200, 50, 4, 20);
        try {
            simpleCaptcha.write(response.getOutputStream());
            RedisUtil.set(SecurityConstants.SPRING_SECURITY_RESTFUL_IMAGE_CODE+uuid, simpleCaptcha.getCode(), 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出
     */
    @PostMapping(value = "/sys/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().build();
    }
}
