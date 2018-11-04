package com.zn.ticketreservationsystem.dmoain.repository;

import com.zn.ticketreservationsystem.dmoain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * @Author: ZN_nick
 * @Date: 2018/11/3 10:44
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(int userId);

}
