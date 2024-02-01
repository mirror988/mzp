package org.gulingjingguai.mzp.common;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class ScheduledTask {
    @Scheduled(cron = "0 0 11-18/2 ? * 1,2,3,4,5")
    void getCronTime(){
        long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);
    }
}
