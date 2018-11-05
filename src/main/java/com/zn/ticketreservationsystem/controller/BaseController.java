package com.zn.ticketreservationsystem.controller;

import com.zn.ticketreservationsystem.dmoain.entity.User;
import com.zn.ticketreservationsystem.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/2 16:53
 * @Version 1.0
 */
@Controller
public class BaseController {
    @Autowired
    private BaseService baseService;


    @GetMapping("/aa")
    @ResponseBody
    public String hello(){
        return "helloWorld";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String userId, String password){

        try {
            int id;
            id = Integer.parseInt(userId);
            User user = baseService.findUserById(id);
            if (user.getPassword().equals(password)){
                user.setLogin(true);
                baseService.save(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return "账号或密码错误";
        }
        return "登录成功";

    }

    @PostMapping("/signup")
    @ResponseBody
    public String signup(String name,String nickName,String password,String payPsd,String sex){
        User user = new User();
        user.setName(name);
        user.setNickName(nickName);
        user.setPassword(password);
        user.setPayPsd(payPsd);
        user.setSex(sex);
        baseService.save(user);
        return "成功";

    }

    @PostMapping("/quit")
    @ResponseBody
    public String quit(String userId){
        try {
            int id;
            id = Integer.parseInt(userId);
            User user = baseService.findUserById(id);
            user.setLogin(false);
            baseService.save(user);

        } catch (Exception e) {
            e.printStackTrace();
            return "发生未知错误，请与管理员联系";
        }
        return "退出成功";
    }
}
