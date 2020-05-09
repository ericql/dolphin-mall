package io.dolphin.mall.security.provider;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.emoji.EmojiUtil;
import io.dolphin.mall.security.enums.App;
import io.dolphin.mall.security.exception.UsernameNotFoundExceptionBase;
import io.dolphin.mall.security.exception.WxErrorExceptionBase;
import io.dolphin.mall.security.model.AppConnect;
import io.dolphin.mall.security.model.DolphinUser;
import io.dolphin.mall.security.service.DolphinUserDetailsService;
import io.dolphin.mall.security.token.MpAuthenticationToken;
import io.dolphin.mall.security.token.MyAuthenticationToken;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description: 微信公众号登陆
 * @Author: Eric Liang
 * @Since: 2020-5-9 14:21
 */
@AllArgsConstructor
public class MpAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final DolphinUserDetailsService dolphinUserDetailsService;
    private final WxMpService wxMpService;

    @Override
    protected Authentication createSuccessAuthentication(Authentication authentication, UserDetails user) {
        MpAuthenticationToken result = new MpAuthenticationToken(user, authentication.getCredentials());
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    protected App getAppInfo() {
        return App.MP;
    }

    @Override
    protected UserDetails retrieveUser(String code, Authentication authentication) throws AuthenticationException {
        DolphinUser loadedUser = null;
        // 如果使用debugger 模式，则返回debugger的用户
        if (BooleanUtil.isTrue(((MyAuthenticationToken)authentication).getDebugger())) {
            loadedUser = new DolphinUser("1" , "debuggerOpenId" ,  this.getAppInfo().value(), true);
            loadedUser.setDebugger(true);
            return loadedUser;
        }

        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;

        AppConnect appConnect = new AppConnect();
        appConnect.setAppId(this.getAppInfo().value());

        try {

            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            loadedUser = dolphinUserDetailsService.loadUserByAppIdAndBizUserId(this.getAppInfo(),wxMpOAuth2AccessToken.getOpenId());

        } catch (WxErrorException e) {
            throw new WxErrorExceptionBase(e.getMessage());
        } catch (UsernameNotFoundExceptionBase var6) {
            WxMpUser wxMpUser = null;
            try {
                wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            } catch (WxErrorException e) {
                throw new WxErrorExceptionBase(e.getMessage());
            }
            appConnect.setNickName(EmojiUtil.toAlias(StrUtil.isBlank(wxMpUser.getNickname())? "": wxMpUser.getNickname()));
            appConnect.setImageUrl(wxMpUser.getHeadImgUrl());
            appConnect.setBizUserId(wxMpUser.getOpenId());
            appConnect.setBizUnionid(wxMpUser.getUnionId());
            dolphinUserDetailsService.insertUserIfNecessary(appConnect);

        }

        if (loadedUser == null) {
            loadedUser = dolphinUserDetailsService.loadUserByAppIdAndBizUserId(this.getAppInfo(), appConnect.getBizUserId());
        }
        return loadedUser;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MpAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
