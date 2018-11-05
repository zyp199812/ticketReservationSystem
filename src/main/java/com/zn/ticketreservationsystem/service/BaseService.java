package com.zn.ticketreservationsystem.service;

import com.zn.ticketreservationsystem.dmoain.entity.User;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/4 13:36
 * @Version 1.0
 */
public interface BaseService {
    User findUserById(int id);
    void save(User user);

}
