package com.zn.ticketreservationsystem.dmoain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单Entity
 *
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
    @Column(length = 18)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 用户id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    /**
     * 航班id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Fight fight;

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
    @Column(length = 18)
    private String ticketId;

    /**
     * 订单创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


}
