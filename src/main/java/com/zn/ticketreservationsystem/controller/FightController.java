package com.zn.ticketreservationsystem.controller;

import com.zn.ticketreservationsystem.dmoain.entity.Fight;
import com.zn.ticketreservationsystem.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/3 11:52
 * @Version 1.0
 */
@Controller
@RequestMapping("/fight")
public class FightController {

    @Autowired
    private FightService fightService;

    @PostMapping("/search")
    @ResponseBody
    public List<Fight> findFightByairPort(String departureAirport,String arrivalAirport ){
        List<Fight> result = fightService.findFightByairPort(departureAirport,arrivalAirport);
        return result;
    }
}
