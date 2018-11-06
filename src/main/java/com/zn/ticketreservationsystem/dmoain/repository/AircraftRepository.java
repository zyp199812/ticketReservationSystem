package com.zn.ticketreservationsystem.dmoain.repository;

import com.zn.ticketreservationsystem.dmoain.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/6 17:47
 * @Version 1.0
 */
public interface AircraftRepository extends JpaRepository<Aircraft,Integer> {
    List<Aircraft> findAircraftById(Integer id);
}
