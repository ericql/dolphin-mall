package io.dolphin.common.bean;

import lombok.Data;

/**
 * @Description: 阿里大鱼配置信息
 * @Author: Eric Liang
 * @Since: 2020-5-8 19:39
 */
@Data
public class ALiDaYu {

    private String accessKeyId;

    private String accessKeySecret;

    private String signName;
}
