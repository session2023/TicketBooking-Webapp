package com.telusko.TicketBookingAppProvider.service;

import com.telusko.TicketBookingAppProvider.model.Passenger;

public interface ITicketBookingService {
	
	public  Passenger registerPassenger(Passenger passenger);
	public Passenger fetchPassengerInfo(Integer id);

}
