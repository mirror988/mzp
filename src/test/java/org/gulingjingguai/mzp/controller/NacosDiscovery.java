package org.gulingjingguai.mzp.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

import java.io.IOException;
import java.util.Properties;

public class NacosDiscovery {
    public static void main(String[] args) throws NacosException, IOException {
        Properties properties = new Properties();
        properties.put("serverAddr", "localhost:8848");
        properties.put("username", "nacos");  // 替换为你的用户名
        properties.put("password", "nacos");  // 替换为你的密码
        NamingService namingService = NamingFactory.createNamingService(properties);
        System.out.println(namingService.getAllInstances("app1"));
        //获取健康的实例
        System.out.println(namingService.selectInstances("app1",true));
        //权重随机算法，获取一个健康的实例
        System.out.println(namingService.selectOneHealthyInstance("app1"));
        //监听服务实例的变化
        namingService.subscribe("app1",event -> {
            if(event instanceof NamingEvent){
                System.out.println(((NamingEvent) event).getServiceName());
                System.out.println(((NamingEvent) event).getInstances());
            }
        });
        System.in.read();
    }
}
