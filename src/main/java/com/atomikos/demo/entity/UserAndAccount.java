package com.atomikos.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class UserAndAccount {

    private UserInfo userInfo;

    private Account account;
}
