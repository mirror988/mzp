package spring;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("spring")
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848",username = "nacos",password = "nacos"))
@NacosPropertySource(dataId = "m",groupId = "mg",autoRefreshed = true)
public class MyConfig {
}
