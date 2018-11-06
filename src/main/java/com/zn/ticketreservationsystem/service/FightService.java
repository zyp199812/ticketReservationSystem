package com.zn.ticketreservationsystem.service;

import com.zn.ticketreservationsystem.dmoain.entity.Fight;


import java.util.Date;
import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/3 11:58
 * @Version 1.0
 */

public interface FightService {
    List<Fight> findFightByairPort(String departureAirport,String arrivalAirport);
    List<Fight> findByTime(Date beginTime,Date endTime);
    List<Fight> findByFightNumber(String fightNumber);
    List<Fight> findByFightId(int id);
}
