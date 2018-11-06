package com.zn.ticketreservationsystem.service;

import com.zn.ticketreservationsystem.dmoain.entity.Ticket;
import com.zn.ticketreservationsystem.dmoain.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/6 14:12
 * @Version 1.0
 */
public interface TicketService {
    List<Ticket> findAllTicketByUser(User user);
    List<Ticket>
    findByCreateTimeAndUser(Date date,User user);
    List<Ticket> findById(int id);

    String createTicket(User user, int fightId, char seatInformation, Date date);
    String pay(int id);
    String abolish(int id);
    String changeTicket(Ticket ticket);
}
