package com.feng.jdbc.curd.dao;

import com.feng.jdbc.curd.domain.User;

import java.util.List;
/**
* @Description 用户持久层
* @Params
* @Return
* @Author Xu Feng
* @Date 2019/9/25 14:46
**/
public interface UserDao {
    /**
    * @Description 查找所有
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/25 14:56
    **/
    List<User> findAll();

    /**
    * @Description 保存用户
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/25 18:51
    **/
    void saveUser(User user);

    /**
    * @Description 根据id删除用户
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/25 19:45
    **/
    void deleteUserById(Integer id);

    /**
    * @Description 根据id修改信息
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/25 21:13
    **/
    void updateUserById(User user);

    /**
    * @Description 根据id查找用户
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 14:15
    **/
    User findById(Integer id);

}
