package com.zn.ticketreservationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "etests";
    }
}
