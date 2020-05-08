package io.dolphin.common.aspect;

import cn.hutool.core.util.StrUtil;
import io.dolphin.common.annotation.RedisLock;
import io.dolphin.common.util.SpelUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lgh
 */
@Aspect
@Component
public class RedisLockAspect {

	@Autowired
	private RedissonClient redissonClient;

	private static final String REDISSON_LOCK_PREFIX = "redisson_lock:";

	@Around("@annotation(redisLock)")
	public Object around(ProceedingJoinPoint joinPoint, RedisLock redisLock) throws Throwable {
		String spel = redisLock.key();
		String lockName = redisLock.lockName();

		RLock rLock = redissonClient.getLock(getRedisKey(joinPoint,lockName,spel));

		rLock.lock(redisLock.expire(),redisLock.timeUnit());

		Object result = null;
		try {
			//执行方法
			result = joinPoint.proceed();

		} finally {
			rLock.unlock();
		}
		return result;
	}

	/**
	 * 将spel表达式转换为字符串
	 * @param joinPoint 切点
	 * @return redisKey
	 */
	private String getRedisKey(ProceedingJoinPoint joinPoint,String lockName,String spel) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method targetMethod = methodSignature.getMethod();
		Object target = joinPoint.getTarget();
		Object[] arguments = joinPoint.getArgs();
		return REDISSON_LOCK_PREFIX + lockName + StrUtil.COLON + SpelUtil.parse(target,spel, targetMethod, arguments);
	}
}
