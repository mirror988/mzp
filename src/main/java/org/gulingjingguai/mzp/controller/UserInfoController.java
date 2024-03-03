package org.gulingjingguai.mzp.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.gulingjingguai.mzp.entity.UserInfoBo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @NacosValue(value = "${date}", autoRefreshed = true)
    String createDate;

    @GetMapping("/basicInfo")
    public UserInfoBo getUserInfo() {
        return null;
    }

    @GetMapping("/createDate")
    public String getCreateDate() {
        return createDate;
    }
}
