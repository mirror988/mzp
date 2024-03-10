package org.gulingjingguai.mzp.lesson.hsp;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UseProxy implements InvocationHandler {

    private Object object;


    public UseProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强");
        Object invoke = method.invoke(object, args);
        System.out.println("后置增强");
        return invoke;
    }
}
