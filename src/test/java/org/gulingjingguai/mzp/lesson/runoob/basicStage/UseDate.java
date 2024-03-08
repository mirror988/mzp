package org.gulingjingguai.mzp.lesson.runoob.basicStage;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UseDate {
    @Test
    public void useDate() throws ParseException {
        Date date = new Date();
        String dateStr = "2024-03-07";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse(dateStr);
        System.out.println(date.after(date1));
        System.out.println(date1.before(date));
    }
}
