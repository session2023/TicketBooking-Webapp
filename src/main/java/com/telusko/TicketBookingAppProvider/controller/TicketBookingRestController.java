package com.telusko.TicketBookingAppProvider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TicketBookingAppProvider.model.Passenger;
import com.telusko.TicketBookingAppProvider.model.Ticket;
import com.telusko.TicketBookingAppProvider.service.ITicketBookingService;

@RestController
@RequestMapping("/api/book-ticket")
public class TicketBookingRestController {
	
	@Autowired
	private ITicketBookingService service;

	
	
	@PostMapping("/getTicketNumber")
	public ResponseEntity<Ticket> registerAllPassenger(@RequestBody Passenger passenger) {
		
		Passenger pass = service.registerPassenger(passenger);
		Ticket ticket = new Ticket();
		ticket.setTicketNumber(pass.getPid());
		
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	@GetMapping("/getTicket/{ticketNumber}")
	public ResponseEntity<Ticket> fetchPassengerInfo(@PathVariable("ticketNumber") Integer ticketNumber) {
		
		Ticket ticket = new Ticket();
		
		Passenger optional = service.fetchPassengerInfo(ticketNumber);
		ticket.setStatus("Confirmed");
		ticket.setTicketCost(898.9);
		ticket.setName(optional.getName());
		ticket.setDeparture(optional.getDeparture());
		ticket.setArrival(optional.getArrival());
		ticket.setDateOfJourney(optional.getDateOfJourney());
		ticket.setTicketNumber(optional.getPid());
		
	
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
		
		
	}

}
