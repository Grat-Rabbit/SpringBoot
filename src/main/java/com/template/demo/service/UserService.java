package com.template.demo.service;
import com.template.demo.model.User;


public interface UserService {

    /**
     * 主要用于jwt查询此id用户是否与token中的用户一致
     * @param userId
     * @return
     */
    User findUserById(String userId);


    /**
     * 获得token的主要代码
     * @param user
     * @return
     */
    String getToken(User user);

}
