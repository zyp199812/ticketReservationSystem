package com.zn.ticketreservationsystem.service.Impl;

import com.zn.ticketreservationsystem.dmoain.entity.Fight;
import com.zn.ticketreservationsystem.dmoain.repository.FightRepository;
import com.zn.ticketreservationsystem.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/3 12:14
 * @Version 1.0
 */
@Service
public class FightServiceImpl implements FightService {
    @Autowired
    private FightRepository fightRepository;
    @Override
    public List<Fight> findFightByairPort(String departureAirport, String arrivalAirport) {
        return fightRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport);


    }

    @Override
    public List<Fight> findByTime(Date beginTime, Date endTime) {
        return fightRepository.findByDepartureTimeBetween(beginTime, endTime);
    }

    @Override
    public List<Fight> findByFightNumber(String fightNumber) {
        return fightRepository.findByFightNumber(fightNumber);
    }

    @Override
    public List<Fight> findByFightId(int id) {
        return fightRepository.findById(id);
    }
}
