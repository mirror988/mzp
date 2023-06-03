package org.gulingjingguai.mzp.controller;

import org.gulingjingguai.mzp.entity.UserInfoBo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    private UserInfoBo userInfoBo;

    @GetMapping("/basicInfo")
    public UserInfoBo getUserInfo() {
        return userInfoBo;
    }
}
