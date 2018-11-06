package com.gp.goods_platform.controller;

import com.gp.goods_platform.dao.UserMapper;
import com.gp.goods_platform.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    private UserMapper userMapper;

    //注册
    @PostMapping("/signin")
    public void setSignin(@RequestBody User user){
        userMapper.insert(user);
    }

    //登陆
    @GetMapping("/login")
    public void isLogin(@RequestParam User user){
        if(user.getUsername()!=null&&user.getUsername()!=""&&user.getEncryptedPassword()!=null&&user.getEncryptedPassword()!=""){
            User selectUser=userMapper.selectUsername(user.getUsername());
            if(selectUser.getUsername()==null){
                System.out.println("没用该用户名");
            }else if(!selectUser.getEncryptedPassword().equals(user.getEncryptedPassword())){
                System.out.println("密码输入错误");
            }else {
                System.out.println("成功登陆");
            }
        }else {
            System.out.println("用户名或密码为空");
        }
    }

    //修改密码
    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody User user){
        Map<String,String> map=new HashMap<String,String>();
        map.put("userName",user.getUsername());
        map.put("userPassword",user.getEncryptedPassword());
        userMapper.updatePassword(map);
    }

    //注销
    @PostMapping("/signout")
    public void signout(@RequestBody User user){
        User selectUser=userMapper.selectUsername(user.getUsername());
        userMapper.deleteByPrimaryKey(selectUser.getUserid());
    }
}
