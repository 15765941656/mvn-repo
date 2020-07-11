package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User login(String userName, String userPass) {
        System.out.println("---------老板....我开始干活了  ------");
        return userMapper.login(userName, userPass);
    }
}
