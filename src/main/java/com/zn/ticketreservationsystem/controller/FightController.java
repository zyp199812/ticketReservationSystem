package com.zn.ticketreservationsystem.controller;

import com.zn.ticketreservationsystem.dmoain.entity.Fight;
import com.zn.ticketreservationsystem.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 航班controller
 *
 * @Author: ZN_nick
 * @Date: 2018/11/3 11:52
 * @Version 1.0
 */
@Controller
@RequestMapping("/fight")
public class FightController {

    @Autowired
    private FightService fightService;

    @PostMapping("/searchbyairport")
    @ResponseBody
    public List<Fight> findFightByAirport(String departureAirport,String arrivalAirport ){
        List<Fight> result = fightService.findFightByairPort(departureAirport,arrivalAirport);
        return result;
    }

    @PostMapping("/searchbytime")
    @ResponseBody
    public List<Fight> findFightByTime(String beginTime,String endTime){

        try {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time1 = new Date();
            Date time2 = new Date();
            time1 = dateFormat.parse(beginTime);
            time2 = dateFormat.parse(endTime);
            List<Fight> result  = fightService.findByTime(time1,time2);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/searchbyfightnumber")
    @ResponseBody
    public List<Fight> findByFightNumber(String fightNumber){
        List<Fight> result = fightService.findByFightNumber(fightNumber);
        return result;
    }

    @PostMapping("/searchbyfightId")
    @ResponseBody
    public List<Fight> findByFightId(String fightId){
        int id;
        id = Integer.parseInt(fightId);

        List<Fight> result = fightService.findByFightId(id);
        return result;
    }

}
