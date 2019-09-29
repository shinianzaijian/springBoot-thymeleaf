package com.feng.jdbc.curd.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* @Description POJO类
* @Params
* @Return
* @Author Xu Feng
* @Date 2019/9/25 14:45
**/
@Data
public class User {
    private Integer id;
    private String username;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String sex;
    private String address;
    private Float money;
}
