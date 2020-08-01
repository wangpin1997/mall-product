package cn.wpin.mall.product.service;

import cn.wpin.mall.product.util.RedissonLock;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
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


    public void testRedis(String productId) throws InterruptedException {
        RLock lock = redissonLock.getRLock(locks);
        boolean bs = lock.tryLock(5, 6, TimeUnit.SECONDS);
        try {
            if (!bs) {
                log.info("进入业务代码: " + locks + "锁已被其他线程占用");
                return;

            }
            // 业务代码
            System.out.println("执行业务代码" + productId);
        } finally {
            if (bs) {
                lock.unlock();
            }


        }
    }
}
