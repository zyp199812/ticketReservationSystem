package com.zn.ticketreservationsystem.dmoain.entity;

import lombok.Data;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String nickName;

    private String password;

    /**
     * 支付密码
     */
    private String payPsd;

    private String sex;

    /**
     * 伪session 用于验证是否已登录
     * 通过随机数和MD5生成一串数字充当session
     */
    private String islogin;

}
