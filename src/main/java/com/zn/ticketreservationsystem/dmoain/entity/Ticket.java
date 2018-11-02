package com.zn.ticketreservationsystem.dmoain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 订单Entity
 * @Author: ZN_nick
 * @Date: 2018/11/2 18:31
 * @Version 1.0
 */
@Data
@Entity
public class Ticket {

    /**
     * 订单ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 航班id
     */
    private String fightId;

    /**
     * 座位信息
     */
    private char seatInformation;

    /**
     * 订单状态
     */
    private char state;

    /**
     * 关联订单id
     */
    private String ticketId;

    /**
     * 订单创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Data createTime;


}
