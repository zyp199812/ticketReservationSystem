package com.zn.ticketreservationsystem.service.Impl;

import com.zn.ticketreservationsystem.Constant.SeatInformationConstant;
import com.zn.ticketreservationsystem.Constant.TicketStateConstant;
import com.zn.ticketreservationsystem.dmoain.entity.Aircraft;
import com.zn.ticketreservationsystem.dmoain.entity.Fight;
import com.zn.ticketreservationsystem.dmoain.entity.Ticket;
import com.zn.ticketreservationsystem.dmoain.entity.User;
import com.zn.ticketreservationsystem.dmoain.repository.AircraftRepository;
import com.zn.ticketreservationsystem.dmoain.repository.FightRepository;
import com.zn.ticketreservationsystem.dmoain.repository.TicketRepository;
import com.zn.ticketreservationsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZN_nick
 * @Date: 2018/11/6 14:13
 * @Version 1.0
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FightRepository fightRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public List<Ticket> findAllTicketByUser(User user) {
        return ticketRepository.findByUser(user);
    }

    @Override
    public String createTicket(User user, int fightId, char seatInformation, Date date) {
        Ticket ticket = new Ticket();
        List<Fight> fight = fightRepository.findById(fightId);
        List<Aircraft> aircraft = aircraftRepository.findAircraftById(fight.get(0).getId());
        switch (seatInformation) {
            case 'A':
                if (aircraft.get(0).getBusinessClassNum() > fight.get(0).getBookedBusinessClassNum()) {
                    ticket.setUser(user);
                    ticket.setFight(fight.get(0));
                    ticket.setSeatInformation(SeatInformationConstant.BUSINESS_CLASS);
                    ticket.setCreateTime(date);
                    ticket.setState(TicketStateConstant.UNPAID);
                    Integer id = ticketRepository.save(ticket).getId();
                    fight.get(0).setBookedBusinessClassNum(fight.get(0).getBookedBusinessClassNum() + 1);
                    fightRepository.save(fight.get(0));
                    return id.toString();
                }
                return "抱歉，您选择的舱位已满，请选择其他舱位试试";

            case 'B':
                if (aircraft.get(0).getEconomyClassNum() > fight.get(0).getBookedEconomyClassNum()) {
                    ticket.setUser(user);
                    ticket.setFight(fight.get(0));
                    ticket.setSeatInformation(SeatInformationConstant.ECONOMY_CLASS);
                    ticket.setCreateTime(date);
                    ticket.setState(TicketStateConstant.UNPAID);
                    ticketRepository.save(ticket);
                    fight.get(0).setBookedEconomyClassNum(fight.get(0).getBookedEconomyClassNum() + 1);
                    fightRepository.save(fight.get(0));
                    return "订单创建成功";
                }
                return "抱歉，您选择的舱位已满，请选择其他舱位试试";
            default:
                break;
        }
        return "服务器繁忙，请稍后再试";
    }

    @Override
    public String pay(int id) {
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setState(TicketStateConstant.WAIT_USE);
        ticketRepository.save(ticket);
        return "支付成功";
    }

    @Override
    public String abolish(int id) {
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setState(TicketStateConstant.CANCEL);
        ticketRepository.save(ticket);
        return "订单取消成功！！！";
    }

    @Override
    public List<Ticket> findByCreateTimeAndUser(Date date, User user) {
        return ticketRepository.findByCreateTimeAndUser(date, user);
    }

    @Override
    public Ticket findById(int id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public String changeTicket(Ticket ticket) {
        List<Fight> fight = fightRepository.findById(ticket.getFight().getId());
        switch (ticket.getSeatInformation()) {
            case SeatInformationConstant.BUSINESS_CLASS:
                fight.get(0).setBookedBusinessClassNum(fight.get(0).getBookedBusinessClassNum() - 1);
                fightRepository.save(fight.get(0));
                break;
            case SeatInformationConstant.ECONOMY_CLASS:
                fight.get(0).setBookedEconomyClassNum(fight.get(0).getBookedEconomyClassNum() - 1);
                fightRepository.save(fight.get(0));
                break;
            default:
                break;
        }
        ticketRepository.save(ticket);
        return "改变订单成功";
    }
}
