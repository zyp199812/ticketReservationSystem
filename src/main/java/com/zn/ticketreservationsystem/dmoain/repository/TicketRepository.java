package com.zn.ticketreservationsystem.dmoain.repository;

import com.zn.ticketreservationsystem.dmoain.entity.Ticket;
import com.zn.ticketreservationsystem.dmoain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/5 10:44
 * @Version 1.0
 */
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
     List<Ticket> findByUser(User user);

     List<Ticket> findTicketById(Integer id);

     List<Ticket> findByCreateTimeAndUser(Date date,User user);


}
