package com.zn.ticketreservationsystem.controller;

import com.zn.ticketreservationsystem.dmoain.entity.User;
import com.zn.ticketreservationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/3 11:51
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "etests";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(String userId,String name,String nickName,String password,String payPsd,String sex){
        int id;
        id = Integer.parseInt(userId);
        User user = userService.findUserById(id);
        if (user.isLogin()){
            user.setName(name);
            user.setNickName(nickName);
            user.setPassword(password);
            user.setPayPsd(payPsd);
            user.setSex(sex);
            userService.save(user);
            return "修改成功";
        }
        return "没有权限,请登录后再试";
    }
}
