package com.feng.jdbc.curd.test;

import com.feng.jdbc.curd.domain.User;
import com.feng.jdbc.curd.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
* @Description 数据库控制层
* @Params
* @Return
* @Author Xu Feng
* @Date 2019/9/25 14:44
**/
@Controller
public class Test {

    @Autowired
    private UserDaoImpl userDao;

    /**
    * @Description 调用方法生成JSON数据
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/25 15:00
    **/
    @RequestMapping("/findAll")
    public String testFindAll(Model model) {
        List<User> users = userDao.findAll();
        model.addAttribute("user",users);
        return "user";
    }

    /**
    * @Description 根据前端返回的数据添加到数据库
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 22:09
    **/
    @PostMapping("/save")
    public String saveUser(User user){
        userDao.saveUser(user);
        System.out.println("成功");
        return "redirect:/findAll";
    }

    /**
    * @Description 页面删除按钮
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 22:10
    **/
    @RequestMapping("/del")
    public String deleteUserById(@RequestParam("id") Integer id){
        System.out.println(id);
        userDao.deleteUserById(id);
        return "redirect:/findAll";
    }

    /**
    * @Description 根据id查询数据库里面的信息并传入前端
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 22:11
    **/
    @RequestMapping("/edt{id}")
    public String edtUserById(@RequestParam("id") Integer id,Model model){
        User user = userDao.findById(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "edt";
    }

    /**
    * @Description 根据提交的信息修改数据库中的数据
    * @Params
    * @Return
    * @Author Xu Feng
    * @Date 2019/9/27 22:12
    **/
    @RequestMapping("/information")
    public String informationEdt(User user){
        userDao.updateUserById(user);
        return "redirect:/findAll";
    }

}
