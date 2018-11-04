package com.zn.ticketreservationsystem.service;

import com.zn.ticketreservationsystem.dmoain.entity.Fight;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/3 11:58
 * @Version 1.0
 */

public interface FightService {
    List<Fight> findFightByairPort(String departureAirport,String arrivalAirport);
}
