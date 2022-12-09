package com.cabbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cabbook.model.Booking;

@Service
public interface BookingService {
	
	public Booking addBooking(Booking booking,int id,long regid);
	public Booking getBookingById(int id);
	public List<Booking> getAllBooking();
	public Booking updateBooking(int id,Booking booking);
	public void deleteBookingById(int d);
	public List<Booking> findByUserId(int id);
	public Booking approverejectBooking(Booking b);

}
