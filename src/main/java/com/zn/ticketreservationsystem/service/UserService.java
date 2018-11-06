package com.zn.ticketreservationsystem.service;

import com.zn.ticketreservationsystem.dmoain.entity.User;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/5 21:22
 * @Version 1.0
 */
public interface UserService {
    void  save(User user);
    User findUserById(int id);

}
