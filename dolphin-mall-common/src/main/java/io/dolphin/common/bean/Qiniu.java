package io.dolphin.common.bean;

import io.dolphin.common.enums.QiniuZone;
import lombok.Data;

/**
 * @Description: 七牛云存储配置信息
 * @Author: Eric Liang
 * @Since: 2020-5-8 19:40
 */
@Data
public class Qiniu {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String resourcesUrl;

    private QiniuZone zone;
}
