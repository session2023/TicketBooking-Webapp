package com.telusko.TicketBookingAppProvider.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.telusko.TicketBookingAppProvider.model.Passenger;


public interface ITicketRepo extends JpaRepository<Passenger, Integer> {

}
