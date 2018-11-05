package com.zn.ticketreservationsystem.dmoain.repository;

import com.zn.ticketreservationsystem.dmoain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/5 10:44
 * @Version 1.0
 */
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
