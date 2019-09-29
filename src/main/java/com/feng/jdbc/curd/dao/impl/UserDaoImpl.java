package com.feng.jdbc.curd.dao.impl;

import com.feng.jdbc.curd.dao.UserDao;
import com.feng.jdbc.curd.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;
/**
* @Description 表现层
* @Params
* @Return
* @Author Xu Feng
* @Date 2019/9/25 14:45
**/
@Controller
public class UserDaoImpl implements UserDao {

    /* 向容器中注入jdbctemplate对象 */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
    * @Description 重写findAll方法
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/25 14:57
    **/
    @Override
    public List<User> findAll() {

        List<User> users  =this.jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    /**
    * @Description 保存用户
    * @Params
    * @Return 
    * @Author Xu Feng
    * @Date 2019/9/27 21:59
    **/
    @Override
    public void saveUser(User user) {
        this.jdbcTemplate.update("insert into user (username,sex,birthday,address,money) values (?,?,?,?,?)",user.getUsername(),
                user.getSex(),user.getBirthday(),user.getAddress(),user.getMoney());
    }

    /**
    * @Description 根据id删除用户
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 22:06
    **/
    @Override
    public void deleteUserById(Integer id) {
        this.jdbcTemplate.update("delete from user where id = ? ", id);
    }

    /**
    * @Description 根据id修改用户信息
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 22:06
    **/
    @Override
    public void updateUserById(User user) {

        this.jdbcTemplate.update("update user set username=?,sex=?,birthday=?,address=?,money=? where id=?",user.getUsername(),
                user.getSex(),user.getBirthday(),user.getAddress(),user.getMoney(),user.getId());
    }

    /**
    * @Description 根据id查找用户
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 22:07
    **/
    @Override
    public User findById(Integer id) {

        User user = this.jdbcTemplate.queryForObject("select * from user where id = ?",new BeanPropertyRowMapper<>(User.class),id);
        return user;
    }

}
