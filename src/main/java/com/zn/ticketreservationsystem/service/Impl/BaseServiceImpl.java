package com.zn.ticketreservationsystem.service.Impl;

import com.zn.ticketreservationsystem.dmoain.entity.User;
import com.zn.ticketreservationsystem.dmoain.repository.UserRepository;
import com.zn.ticketreservationsystem.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/4 13:36
 * @Version 1.0
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}
