package com.cabbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbook.model.Booking;
import com.cabbook.model.DriverInfo;
import com.cabbook.model.Registration;
import com.cabbook.repository.BookingRepository;

@Service
public class BookingServiceImp implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private DriverInfoService dRepo;


	@Autowired
	private RegistrationService Rrepo;
	
	@Override
	public Booking addBooking(Booking booking,int id,long regid) {
		try
		{
			DriverInfo d=dRepo.getDriverInfoById(id);
			booking.setDriverId(d);
			System.out.println(d);
			Registration r=Rrepo.findById(regid);
			System.out.println(r);
			booking.setRegistrationId(r);
			
			bookingRepo.save(booking);
			
		}
		catch (Exception e) {
			
			System.out.println("Exception while adding Booking"+e);
		}
		//System.out.println("Booking Adding Successfully ");
		return booking;
	}

	@Override
	public List<Booking> getAllBooking() {
	List<Booking> list=null;
	try {
		list=bookingRepo.findAll();
	}
	catch (Exception e) {
		System.out.println("Exception while getting Booking");
	}
		return  list;
	}

	@Override
	public Booking updateBooking(int id, Booking b) 
	{
		Optional<Booking> op=bookingRepo.findById(id);
		if(op.isPresent())
		{
			Booking booking=op.get();
			booking.setSource(b.getSource());
			booking.setDestination(b.getDestination());
			
			bookingRepo.save(booking);
		}
		else
		{
			System.out.println("Booking not available");
		}
		System.out.println("Booking Updating Successfully ");
		return b;
	}

	@Override
	public void deleteBookingById(int id) 
	{
		Booking book=new Booking();
		
		try{
			
			book=getBookingById(id);
			if(book!=null)
			{
				bookingRepo.deleteById(id);
				
			}
		}
		catch (Exception e) {
			System.out.println("Exception while removing BookingById");
		}
		System.out.println("Booking deleted Successfully ");
	}

	@Override
	public Booking getBookingById(int id) 
	{
		Optional<Booking> op=bookingRepo.findById(id);
		if(op.isPresent())
		{
			Booking book=op.get();
			 return book;
		}
		else 
		{
			System.out.println("Booking not availabe");
			return null;
		}
	}

	@Override
	public List<Booking> findByUserId(int id) {
		List<Booking> list=bookingRepo.findBookingByUserId(id);
		
		return list;
	}

	@Override
	public Booking approverejectBooking(Booking b) {
		// TODO Auto-generated method stub
		
		Booking da=bookingRepo.save(b);
		return da;
	}

}

	
	


