package org.gulingjingguai.mzp.lesson.runoob.basicStage;

/**
 * 控制变量的可见性和有序性
 * 1.可见性：确保所有线程都能立即看到该变量的最新修改值。
 * 这意味着当一个线程对volatile变量进行写操作后，其他线程能够立即看到这个写入的新值，而不是从各自的工作内存（缓存）中读取旧值。
 * 这是因为 volatile 变量的更新会强制将新值刷新到主内存，并且读取volatile变量时总是会从主内存重新加载。
 * 2.有序性
 * 防止可能出现的指令重排
 */
public class UseVolatile {
    //    private static boolean initialized = false; // 假设这是普通的非volatile变量
    private volatile static boolean initialized = false; // 假设这是普通的非volatile变量

    public static void init() {
        if (!initialized) { // 线程A
            //doComplexInitialization(); // 步骤1. 复杂初始化操作
            initialized = true; // 步骤2. 设置初始化完成标志为true
        }
    }

    /**
     * 没有使用volatile修饰，可能重拍，导致步骤2优先于步骤1执行。
     * 而主线程又读到 initialized 被修改
     */
    public static void main(String[] args) {
        new Thread(() -> init()).start(); // 启动线程A进行初始化
        while (!initialized) { // 主线程B等待初始化完成
        }
    }
}
