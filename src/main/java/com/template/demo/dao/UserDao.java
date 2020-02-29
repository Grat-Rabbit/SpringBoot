package com.template.demo.dao;


import com.template.demo.model.User;
import org.apache.ibatis.annotations.Mapper;



@Mapper
    public interface UserDao {
    User findUserById(String userId);
}
