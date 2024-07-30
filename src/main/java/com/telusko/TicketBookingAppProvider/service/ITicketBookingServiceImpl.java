package com.telusko.TicketBookingAppProvider.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.TicketBookingAppProvider.dao.ITicketRepo;
import com.telusko.TicketBookingAppProvider.model.Passenger;

@Service
public class ITicketBookingServiceImpl implements ITicketBookingService {
	
	@Autowired
	private ITicketRepo repo;
	


	@Override
	public Passenger registerPassenger(Passenger passenger) {
		
		return repo.save(passenger);
	}

	@Override
	public Passenger fetchPassengerInfo(Integer id) {
		
		
		Optional<Passenger> optional = repo.findById(id);
		return optional.get();
		
	}

}
