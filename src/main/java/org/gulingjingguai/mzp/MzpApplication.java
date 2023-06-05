package org.gulingjingguai.mzp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import sun.misc.Contended;

@SpringBootApplication
@Contended
@EnableScheduling
public class MzpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MzpApplication.class, args);
    }
}
