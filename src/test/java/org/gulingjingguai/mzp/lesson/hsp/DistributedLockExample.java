package org.gulingjingguai.mzp.lesson.hsp;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class DistributedLockExample {

    public static void main(String[] args) {
        // 创建 Redisson 配置对象
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");

        // 创建 Redisson 客户端
        RedissonClient redisson = Redisson.create(config);

        // 获取分布式锁对象
        RLock lock = redisson.getLock("myLock");

        try {
            // 尝试加锁，最多等待10秒，持有锁的时间30秒
            boolean isLocked = lock.tryLock(10, 30, java.util.concurrent.TimeUnit.SECONDS);

            if (isLocked) {
                // 执行加锁成功后的业务逻辑
                System.out.println("成功获取到分布式锁");

                // 模拟业务处理
                Thread.sleep(5000); // 业务处理时间

            } else {
                // 加锁失败，执行失败处理逻辑
                System.out.println("获取分布式锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
            System.out.println("释放分布式锁");
        }

        // 关闭 Redisson 客户端
        redisson.shutdown();
    }
}
