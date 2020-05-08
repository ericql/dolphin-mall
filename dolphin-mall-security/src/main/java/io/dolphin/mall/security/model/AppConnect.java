package io.dolphin.mall.security.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020/5/8 23:06
 */
@Data
@TableName("tz_app_connect")
public class AppConnect {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 本系统userId
     */

    private String userId;

    /**
     * 第三方系统id 1：微信小程序
     */

    private Integer appId;

    /**
     * 第三方系统昵称
     */

    private String nickName;

    /**
     * 第三方系统头像
     */

    private String imageUrl;

    /**
     * 第三方系统userid
     */

    private String bizUserId;

    /**
     * 第三方系统unionid
     */

    private String bizUnionid;
}
