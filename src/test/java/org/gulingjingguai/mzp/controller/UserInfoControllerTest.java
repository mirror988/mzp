package org.gulingjingguai.mzp.controller;

import org.gulingjingguai.mzp.entity.UserInfoBo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class UserInfoControllerTest {

    @Autowired
    private UserInfoController userInfoController;

    @Test
    void testGetUserInfo() {
        UserInfoBo userInfoBo = userInfoController.getUserInfo();
        assertNull(userInfoBo);
    }

    @Test
    void getSystemTime(){
        long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);
    }
}