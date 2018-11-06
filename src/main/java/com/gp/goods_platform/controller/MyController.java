package com.gp.goods_platform.controller;

import com.gp.goods_platform.dao.UserMapper;
import com.gp.goods_platform.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private UserMapper userMapper;

    //注册
    @PostMapping("/signin")
    public void setSignin(@RequestBody User user){
        userMapper.insert(user);
    }
}
