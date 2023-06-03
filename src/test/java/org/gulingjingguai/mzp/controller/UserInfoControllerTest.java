package org.gulingjingguai.mzp.controller;

import org.gulingjingguai.mzp.entity.UserInfoBo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

}