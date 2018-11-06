package com.zn.ticketreservationsystem.dmoain.repository;

import com.zn.ticketreservationsystem.dmoain.entity.Fight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

    /**
     * 根据出发的时间段去寻找航班
     *
     * @param beginTime 开始时间
     * @param endTime 截止时间
     * @return List<Fight>
     */
    List<Fight> findByDepartureTimeBetween(Date beginTime, Date endTime);

    /**
     * 根据航班号进行查询
     * @param fightNumber
     * @return List<Fight>
     */
    List<Fight> findByFightNumber(String fightNumber);

    /**
     * 根据id进行查找
     *
     * @param id
     * @return
     */

    @Query(value = "select * FROM fight WHERE id = :id",nativeQuery = true)
    List<Fight> findById(@Param("id")Integer id);
}

