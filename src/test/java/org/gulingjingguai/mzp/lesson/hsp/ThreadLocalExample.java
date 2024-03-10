package org.gulingjingguai.mzp.lesson.hsp;

import java.util.function.Function;

public class ThreadLocalExample {

    private static ThreadLocal<Integer> counter = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            // 每个线程都有一个独立的计数器
            counter.set(0);

            for (int i = 0; i < 5; i++) {
                int count = counter.get();
                System.out.println(Thread.currentThread().getName() + " - Count: " + count);
                counter.set(count + 1);
            }
        };

        // 创建并启动两个线程
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
