package com.qfedu.ljb.server.user.service;


import com.qfedu.ljb.common.exception.UserException;
import com.qfedu.ljb.common.vo.R;
import com.qfedu.ljb.entity.User;


/**
 *@Author feri
 *@Date Created in 2019/6/12 16:19
 */
public interface UserService {

    R save(User user) throws UserException;
    R all();
    R checkPhone(String phone);
}
