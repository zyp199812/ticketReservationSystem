package com.zn.ticketreservationsystem.controller;

import com.zn.ticketreservationsystem.Constant.TicketStateConstant;
import com.zn.ticketreservationsystem.dmoain.entity.Ticket;
import com.zn.ticketreservationsystem.dmoain.entity.User;
import com.zn.ticketreservationsystem.service.FightService;
import com.zn.ticketreservationsystem.service.TicketService;
import com.zn.ticketreservationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/4 12:33
 * @Version 1.0
 */
@Controller
@RequestMapping("/user/ticket")
public class TicketController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FightService fightService;

    @PostMapping("/createTicket")
    @ResponseBody
    public String createTicket(String userId,String fightId,char seatInformation){
        int id;
        id = Integer.parseInt(userId);
        User user = userService.findUserById(id);
        int fightID;
        fightID = Integer.parseInt(fightId);
        if (user.isLogin()){
            Date date = new Date();
            return ticketService.createTicket(user,fightID,seatInformation,date);


        }
        return "添加失败，请验证是否登录！！！";

    }
    @PostMapping("/changeTicket")
    @ResponseBody
    public String changeTicket(String userId,String fightId,char seatInformation,String oldTicketid){
        int id;
        id = Integer.parseInt(userId);
        User user = userService.findUserById(id);
        int fightID;
        fightID = Integer.parseInt(fightId);
        int oldTicketId;
        oldTicketId = Integer.parseInt(oldTicketid);
        if (user.isLogin()){
            Date date = new Date();
            String z = ticketService.createTicket(user,fightID,seatInformation,date);
            int a = Integer.parseInt(z);
            Ticket targetTicket = ticketService.findById(a);
            Ticket oldTicket = ticketService.findById(oldTicketId);
            oldTicket.setTicketId(targetTicket.getId());
            oldTicket.setState(TicketStateConstant.CANCEL);
            return ticketService.changeTicket(oldTicket);



        }
        return "修改订单信息失败，请验证是否登录！！！";
    }
    @PostMapping("/findAllTicket")
    @ResponseBody
    public List<Ticket> findAllTicket(String userId){
        int id;
        id = Integer.parseInt(userId);
        User user = userService.findUserById(id);
        if (user.isLogin()){
            List<Ticket> result = ticketService.findAllTicketByUser(user);
            return result;
        }
        return null;

    }
    @PostMapping("/pay")
    @ResponseBody
    public String pay(String userId,String ticketId){
        int id;
        id = Integer.parseInt(userId);
        int ticket;
        ticket = Integer.parseInt(ticketId);
        User user = userService.findUserById(id);
        if (user.isLogin()){
            return ticketService.pay(ticket);
        }
        return "支付失败，请验证是否登录！！！";
    }
    @PostMapping("/abolish")
    @ResponseBody
    public String abolish(String userId,String ticketId){
        int id;
        id = Integer.parseInt(userId);
        int ticket;
        ticket = Integer.parseInt(ticketId);
        User user = userService.findUserById(id);
        if (user.isLogin()){
            return ticketService.abolish(ticket);
        }
        return "请验证是否登录！！！";
    }

}
