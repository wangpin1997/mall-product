package cn.wpin.mall.product.service;

import cn.wpin.mall.product.util.RedissonLock;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 用来测试分布式锁的service
 *
 * @author wangpin
 */
@Slf4j
@Component
public class RedissonService {

    private static String locks = "product";

    @Autowired
    private RedissonLock redissonLock;

    @Autowired
    private RedisClient redisClient;


    public void testRedis(String productId) {
        RLock lock = redissonLock.getRLock(locks);
        try {
            boolean bs = lock.tryLock(5, 6, TimeUnit.SECONDS);
            if (bs) {
                // 业务代码
                log.info("进入业务代码: " + locks + "锁已被占用");

                lock.unlock();
            } else {
                log.info("进入业务代码: " + locks + "锁已被当前定时任务占用，其他定时任务直接放行");
            }
        } catch (Exception e) {
            log.error("", e);
            lock.unlock();
        }
    }
}
