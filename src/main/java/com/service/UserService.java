package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名和密码登录
     * @param userName 账号
     * @param userPass 密码
     * @return 用户信息
     */
    User login(String userName, String userPass);

    void addUser(User user);

    List<User> listUser();

    User getUserById(Integer id);
}
