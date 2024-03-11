package org.gulingjingguai.mzp.lesson.hsp;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UseCglibProxy implements MethodInterceptor {

    private Object object;

    public UseCglibProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cg前置增强");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cg后置增强");
        return o1;
    }
}
