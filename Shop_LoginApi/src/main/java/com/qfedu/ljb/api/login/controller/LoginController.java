package com.qfedu.ljb.api.login.controller;

import com.qfedu.ljb.api.login.service.LoginService;
import com.qfedu.ljb.common.config.ProjectConfig;
import com.qfedu.ljb.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    //登录
    @PostMapping("/api/login/login.do")
    public R login(@RequestParam("phone") String phone,@RequestParam("password") String password){
        System.out.println(phone);
        System.out.println(password);
        return loginService.login(phone, password);
    }
    //检查是否有效
    @GetMapping("/api/login/checklogin.do")
    public R check(HttpServletRequest request){
        return loginService.check(request.getHeader(ProjectConfig.TOKENHEAD));
    }
    //注销
    @GetMapping("/login/exit.do")
    public R exit(HttpServletRequest request){
        return loginService.exit(request.getHeader(ProjectConfig.TOKENHEAD));
    }
}
