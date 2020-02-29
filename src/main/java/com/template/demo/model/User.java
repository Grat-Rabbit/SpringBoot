package com.template.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;


@Data
@JsonIgnoreProperties(value = {"password"}) //返回的时候，隐藏关键字
@JsonInclude(Include.NON_NULL)
public class User {
    private String userId;
    private String password;
    private String userName;

}
