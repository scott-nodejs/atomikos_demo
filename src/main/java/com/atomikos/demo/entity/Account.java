package com.atomikos.demo.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
public class Account {

    private int id;

    private int userId;

    private int account;
}
