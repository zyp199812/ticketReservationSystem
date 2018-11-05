package com.zn.ticketreservationsystem.service.Impl;

import com.zn.ticketreservationsystem.dmoain.entity.User;
import com.zn.ticketreservationsystem.dmoain.repository.UserRepository;
import com.zn.ticketreservationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/5 21:22
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }


    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}
