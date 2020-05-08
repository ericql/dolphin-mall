package io.dolphin.common.serializer.redis;

import io.dolphin.common.serializer.FSTSerializer;
import lombok.SneakyThrows;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;

/**
 * @Description: 使用fst 进行reids的序列化
 * @Author: Eric Liang
 * @Since: 2020-5-8 20:12
 */
public class FstRedisSerializer implements RedisSerializer<Object> {

    private static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    @SneakyThrows
    public byte[] serialize(Object o) {
        if (o == null) {
            return EMPTY_ARRAY;
        }
        return new FSTSerializer().getConfig().asByteArray(o);
    }

    @Override
    @SneakyThrows
    public Object deserialize(byte[] bytes) {
        if (isEmpty(bytes)) {
            return null;
        }
        return new FSTSerializer().getConfig().asObject(bytes);
    }

    private static boolean isEmpty(@Nullable byte[] data) {
        return (data == null || data.length == 0);
    }
}
