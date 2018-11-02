package com.zn.ticketreservationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/2 16:53
 * @Version 1.0
 */
@Controller
public class HelloWorldController {
    @GetMapping("/aa")
    @ResponseBody
    public String hello(){
        return "helloWorld";
    }
}
