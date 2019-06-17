package com.qfedu.ljb.server.user.dao;

import com.qfedu.ljb.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> all();
    int insert(User record);

    User selectByPhone(String phone);
}