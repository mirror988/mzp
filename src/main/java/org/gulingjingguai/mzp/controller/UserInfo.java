package org.gulingjingguai.mzp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfo {
    @GetMapping("/basicInfo")
    public String getUserInfo() {
        return null;
    }
}
