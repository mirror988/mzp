package org.gulingjingguai.mzp;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;
import java.util.concurrent.Executor;

@SpringBootTest
class MzpApplicationTests {

    @Value("${sdk.server-addr:}")
    String serverAddr;

    @Value("${sdk.dataId:}")
    String dataId;

    @Value("${sdk.group:}")
    String group;

    @Value("${sdk.username:}")
    String username;

    @Value("${sdk.password:}")
    String password;

    @Test
    void contextLoads() {
    }


    @Test
    public ConfigService connectNacos() throws NacosException {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, this.serverAddr);
        properties.put(PropertyKeyConst.USERNAME, this.username);
        properties.put(PropertyKeyConst.PASSWORD, this.password);
        return NacosFactory.createConfigService(properties);
    }

    @Test
    public void getNacosConfig() throws NacosException {
        String content = connectNacos().getConfig(this.dataId, this.group, 5000);
        System.out.println(content);
    }

    @Test
    public void getListenerConfig() throws NacosException, InterruptedException {
        connectNacos().addListener(this.dataId, this.group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println(configInfo);
            }
        });
        Thread.sleep(30000);
    }

}
