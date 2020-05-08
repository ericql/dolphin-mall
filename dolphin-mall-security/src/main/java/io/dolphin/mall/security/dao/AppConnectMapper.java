package io.dolphin.mall.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.dolphin.mall.security.model.AppConnect;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020/5/8 23:06
 */
public interface AppConnectMapper extends BaseMapper<AppConnect> {

    AppConnect getByBizUserId(@Param("bizUserId") String bizUserId, @Param("appId") Integer appId);

    AppConnect getByUserId(@Param("userId") String userId, @Param("appId") Integer appId);

    String getUserIdByUnionId(@Param("bizUnionId") String bizUnionId);
}
