package com.template.demo.controller;


import com.template.demo.model.User;
import com.template.demo.service.impl.UserServiceImpl;
import com.template.demo.utils.Result;
import com.template.demo.utils.annotation.MultiRequestBody;
import com.template.demo.utils.annotation.PassToken;
import com.template.demo.utils.annotation.UserLoginToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class testController {
    @Autowired
    private UserServiceImpl UserServiceImpl;
    Result result = new Result();

    @PassToken
    @PostMapping ("/login")
    //测试jwt登录：userId为14001，password为1,会返回一串token数值
    public Result login(){

        User user = new User();
        user.setUserId("14001");
        user.setPassword("1");
        result.setStatus(true);
        result.setData(UserServiceImpl.getToken(user));
        return result;
    }

    @PassToken
    @PostMapping ("/exception")
    //测试错误异常和MultiRequestBody
    public void exception(@MultiRequestBody String identity){
        throw new RuntimeException("这个异常名是你自己传入的："+identity);
    }

    @UserLoginToken
    @GetMapping ("/ban")
    //测试jwt中是否对未登录用户进行拦截
    public Result ban(){
        System.out.println("进入成功");
        result.setData("进入成功");
        return result;
    }






}

