package com.template.demo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.template.demo.dao.UserDao;
import com.template.demo.model.User;
import com.template.demo.service.UserService;
import com.template.demo.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    public User user;
    @Override
    public User findUserById(String userId) {
        user = userDao.findUserById(userId);
        return  user;
    }

    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getUserId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
