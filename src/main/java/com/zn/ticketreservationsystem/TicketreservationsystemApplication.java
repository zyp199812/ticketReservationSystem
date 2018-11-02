package com.zn.ticketreservationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication

public class TicketreservationsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketreservationsystemApplication.class, args);
    }
}
