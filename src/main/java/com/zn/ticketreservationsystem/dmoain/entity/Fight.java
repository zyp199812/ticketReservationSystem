package com.zn.ticketreservationsystem.dmoain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 *航班Entity
 * 机场采用三字代码识别
 *
 * @Author: ZN_nick
 * @Date: 2018/11/2 11:10
 * @Version 1.0
 */
@Data
@Entity
public class Fight {
    /**
     * id
     */
    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    /**
     * 航班号
     */
    @Column(length = 6)
    private String fightNumber;

    /**
     * 飞机ID
     */
    private String aircraftId;

    /**
     * 出发机场
     */
    @Column(length = 3)
    private String departureAirport;

    /**
     * 到达机场
     */
    @Column(length = 3)
    private String arrivalAirport;

    /**
     * 起飞时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

    /**
     * 预计到达时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    /**
     * 商务舱已订人数
     */
    private int bookedBusinessClassNum;

    /**
     * 经济舱已订人数
     */
    private int bookedEconomyClassNum;

}
