package com.qfedu.ljb.server.user.controller;

import com.qfedu.ljb.common.exception.UserException;
import com.qfedu.ljb.common.vo.R;
import com.qfedu.ljb.entity.User;
import com.qfedu.ljb.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //查询
    @GetMapping("user/all.do")
    public R all(){

        return userService.all();
    }
    //新增
    @PostMapping("user/save.do")
    public R save(@RequestBody  User user) throws UserException {
        return  userService.save(user);
    }
    // 校验手机号是否存在
    @GetMapping("user/checkphone.do")
    public R check(@RequestParam("phone") String phone){
        return userService.checkPhone(phone);
    }
}
