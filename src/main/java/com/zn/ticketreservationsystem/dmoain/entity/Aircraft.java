package com.zn.ticketreservationsystem.dmoain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    private String id;

    private int BusinessClassNum;

    private int EconomyClassNum;

}
