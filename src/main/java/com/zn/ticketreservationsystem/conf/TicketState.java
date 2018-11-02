package com.zn.ticketreservationsystem.conf;

/**
 * 订单状态
 *
 * @Author: ZN_nick
 * @Date: 2018/11/2 18:53
 * @Version 1.0
 */
public interface TicketState {
    /**
     * 未支付
     */
    String UNPAID ="A";

    /**
     * 等待使用
     */
    String WAIT_USE = "B";

    /**
     * 已完成
     */
    String COMPLETED = "C";

    /**
     * 取消
     */
    String CANCEL = "D";



}
