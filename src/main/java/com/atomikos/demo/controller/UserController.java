package com.atomikos.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atomikos.demo.entity.Account;
import com.atomikos.demo.entity.UserAndAccount;
import com.atomikos.demo.entity.UserInfo;
import com.atomikos.demo.service.UserAndAccountService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserAndAccountService userAndAccountService;

    @PostMapping(value = "update")
    public Object getUser(@RequestBody UserAndAccount userAndAccount){
        UserInfo userInfo = userAndAccount.getUserInfo();
        Account account = userAndAccount.getAccount();
        return userAndAccountService.update(userInfo,account);
    }
}
