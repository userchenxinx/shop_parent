package com.qfedu.ljb.server.dao;

import com.qfedu.ljb.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where flag=1 and phone=#{phone}")
    User selectByPhone(String phone);
}
