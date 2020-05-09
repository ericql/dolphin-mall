package io.dolphin.mall.security.handler;

import cn.hutool.core.util.CharsetUtil;
import io.dolphin.mall.security.exception.BaseDolphinAuth2Exception;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: 登陆失败处理
 * @Author: Eric Liang
 * @Since: 2020-5-9 14:08
 */
@Component
@Slf4j
public class LoginAuthFailedHandler implements AuthenticationFailureHandler {
    @Override
    @SneakyThrows
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (!(exception instanceof BaseDolphinAuth2Exception)) {
            return;
        }

        BaseDolphinAuth2Exception auth2Exception = (BaseDolphinAuth2Exception) exception;

        response.setCharacterEncoding(CharsetUtil.UTF_8);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(auth2Exception.getHttpErrorCode());
        PrintWriter printWriter = response.getWriter();
        printWriter.append(auth2Exception.getMessage());
    }
}
