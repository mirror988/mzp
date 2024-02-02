package org.gulingjingguai.mzp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import sun.misc.Contended;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@Contended
@EnableScheduling
public class MzpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MzpApplication.class, args);
    }

    @PostConstruct
    void setDefaultTimeZone(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }
}
