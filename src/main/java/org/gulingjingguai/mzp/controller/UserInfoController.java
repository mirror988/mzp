package org.gulingjingguai.mzp.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.gulingjingguai.mzp.common.CommonConfig;
import org.gulingjingguai.mzp.entity.UserInfoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserInfoController {

    @Autowired
    private CommonConfig commonConfig;



    @GetMapping("/basicInfo")
    public UserInfoBo getUserInfo() {
        return null;
    }

    @GetMapping("/createDate")
    public String getCreateDate() {
        return commonConfig.getCreateDate();
    }

    @GetMapping("/getTime")
    public String getTime() {
        return commonConfig.getTime();
    }

    @GetMapping("/getName")
    public String getName() {
        return commonConfig.getName();
    }
}
