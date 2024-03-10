package org.gulingjingguai.mzp.lesson.hsp;

import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class testProxy {
    @Test
    public void testJdkProxy(){
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new UseProxy(new UserServiceImpl()));
        userService.readBook();
        userService.rentingHouse();
    }

    @Test
    public void testCglibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new useCglibProxy(UserServiceImpl.class));
        UserServiceImpl userService = (UserServiceImpl)enhancer.create();
        userService.readBook();
        userService.rentingHouse();
    }
}
