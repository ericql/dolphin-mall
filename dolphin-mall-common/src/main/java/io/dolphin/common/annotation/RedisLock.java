package io.dolphin.common.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 使用redis进行分布式锁
 * @author Eric
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {

	/**
	 * redis锁 名字
	 */
	String lockName() default "";

	/**
	 * redis锁 key 支持spel表达式
	 */
	String key() default "";

	/**
	 * 过期秒数,默认为5毫秒
	 *
	 * @return 轮询锁的时间
	 */
	int expire() default 5000;

	/**
	 * 超时时间单位
	 *
	 * @return 秒
	 */
	TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
