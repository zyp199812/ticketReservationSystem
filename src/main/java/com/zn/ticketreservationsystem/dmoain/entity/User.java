package com.zn.ticketreservationsystem.dmoain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户Entity
 *
 * @Author: ZN_nick
 * @Date: 2018/11/2 11:04
 * @Version 1.0
 */
@Data
@Entity
public class User {
    @Id
    @Column(length = 50)
    private String id;

    private String name;

    private String nickName;

    private String password;

    private String payPsd;

    private String sex;

    private String islogin;

}
