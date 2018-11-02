package com.zn.ticketreservationsystem.dmoain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 飞机Entity
 *
 * @Author: ZN_nick
 * @Date: 2018/11/2 11:02
 * @Version 1.0
 */
@Data
@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 所属航空公司
     * 使用二字代码
     */
    @Column(length = 2)
    private String from;

    /**
     * 商务舱座位数
     */
    private int businessClassNum;

    /**
     * 经济舱座位数
     */
    private int economyClassNum;

}
