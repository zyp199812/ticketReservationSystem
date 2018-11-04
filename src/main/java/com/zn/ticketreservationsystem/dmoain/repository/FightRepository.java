package com.zn.ticketreservationsystem.dmoain.repository;

import com.zn.ticketreservationsystem.dmoain.entity.Fight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/3 11:54
 * @Version 1.0
 */
public interface FightRepository  extends JpaRepository<Fight,String> {
    /**
     * 根据出发和降落地点查找航班
     *
     * @param departureAirport 出发机场
     * @param arrivalAirport 降落机场
     * @return List<Fight>
     */
    List<Fight> findByDepartureAirportAndArrivalAirport(String departureAirport, String arrivalAirport);
}
