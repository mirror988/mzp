package org.gulingjingguai.mzp;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import sun.misc.Contended;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@Contended
@EnableScheduling
//@NacosPropertySource(dataId = "m",groupId = "mg",autoRefreshed = true)
public class MzpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MzpApplication.class, args);
    }

    @PostConstruct
    void setDefaultTimeZone(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }
}
