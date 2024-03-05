package org.gulingjingguai.mzp.controller;


import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

import java.io.IOException;
import java.util.Properties;

public class NaocsRegistry {
    public static void main(String[] args) throws NacosException, IOException {
        Properties properties = new Properties();
        properties.put("serverAddr", "localhost:8848");
        properties.put("username", "nacos");  // 替换为你的用户名
        properties.put("password", "nacos");  // 替换为你的密码
        NamingService namingService = NamingFactory.createNamingService(properties);
        namingService.registerInstance("app1","11.11.11.11",9005,"bg");

        NamingService namingService1 = NamingFactory.createNamingService(properties);
        namingService1.registerInstance("app1","11.11.11.12",9005,"bg");

        NamingService namingService2 = NamingFactory.createNamingService(properties);
        namingService2.registerInstance("app1","11.11.11.13",9005,"sh");
        System.in.read();
    }
}
