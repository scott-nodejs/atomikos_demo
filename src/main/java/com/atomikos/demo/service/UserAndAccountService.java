package com.atomikos.demo.service;

import com.atomikos.demo.dao.slave.AccountDao;
import com.atomikos.demo.dao.master.UserInfoDao;
import com.atomikos.demo.entity.Account;
import com.atomikos.demo.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserAndAccountService {

    @Resource
    private AccountDao accountDao;

    @Resource
    private UserInfoDao userInfoDao;

    public Object getUserAndAccount(String name){
        UserInfo user = userInfoDao.findByUserName(name);
        Account account = accountDao.findByUserId(user.getId());
        Map<String,Object> map = new HashMap();
        map.put("username",user.getName());
        map.put("age",user.getAge());
        map.put("account",account.getAccount());
        return map;
    }

    @Transactional(rollbackFor = Exception.class)
    public Object update(UserInfo userInfo, Account account){
        userInfoDao.update(userInfo);
        accountDao.update(account);
        return getUserAndAccount(userInfo.getName());
    }
}
