package cn.taroco.common.redis.lock;

import cn.taroco.common.redis.constant.RedisToolsConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.integration.support.locks.LockRegistry;

/**
 * 分布式锁配置
 *
 * @author liuht
 * @create 2020-03-18 10:01
 */
@Configuration
public class DistributeLockConfiguration {

    @Bean
    @Primary
    public LockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory, RedisToolsConstant.DISTRIBUTE_LOCK_PREFIX, 3000L);
    }
}
