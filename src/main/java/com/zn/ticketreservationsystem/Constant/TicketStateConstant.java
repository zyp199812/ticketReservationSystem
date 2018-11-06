package com.zn.ticketreservationsystem.Constant;

/**
 * 订单状态
 *
 * @Author: ZN_nick
 * @Date: 2018/11/2 18:53
 * @Version 1.0
 */
public interface TicketStateConstant {
    /**
     * 未支付
     */
    char UNPAID ='A';

    /**
     * 等待使用
     */
    char WAIT_USE = 'B';

    /**
     * 已完成
     */
    char COMPLETED = 'C';

    /**
     * 取消
     */
    char CANCEL = 'D';



}
