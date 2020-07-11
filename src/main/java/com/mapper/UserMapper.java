package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 根据用户名和密码登录
     * @param userName 账号
     * @param userPass 密码
     * @return 用户信息
     */
    User login(@Param("userName") String userName, @Param("userPass") String userPass);
}
