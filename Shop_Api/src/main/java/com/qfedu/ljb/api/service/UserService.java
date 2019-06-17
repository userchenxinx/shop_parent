package com.qfedu.ljb.api.service;

import com.qfedu.ljb.common.vo.R;
import com.qfedu.ljb.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserProvider")
public interface UserService {
    @GetMapping("user/all.do")
    R all();
    // 新增
    @PostMapping("user/save.do")
    R save(@RequestBody User user);
    // 校验手机号是否存在
    @GetMapping("user/checkphone.do")
    R check(@RequestParam("phone") String phone);

}
