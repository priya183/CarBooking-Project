package com.cabbook.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbook.model.Booking;
import com.cabbook.model.DriverInfo;
import com.cabbook.service.BookingServiceImp;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingServiceImp bookingService;
	
	@GetMapping("/findBookingById/{id}")
	public Booking findBookingById(@PathVariable int id) {               
    Booking r= bookingService.getBookingById(id);
     return r;
    }

	@PostMapping("/addBooking/{id}/{regid}")
	public Booking addBooking(@Valid @RequestBody Booking booking,@PathVariable int id,@PathVariable long regid) {
		
		System.out.println("regid "+regid);
		System.out.println("Inside add api "+booking);
		System.out.println("Id "+id);
		
		Booking r=bookingService.addBooking(booking,id,regid);
		return r;
	}
	
	@GetMapping("/getAllBooking")
	public List<Booking> getAllBooking()
	{
		List<Booking> list=bookingService.getAllBooking();
		return list;
		
	}
	@PutMapping("/updateBookingById/{id}")
	public Booking updateBookingById(@PathVariable int id,Booking booking)
	{
		return bookingService.updateBooking(id, booking);
	}
	@DeleteMapping("/deleteMappingById/{id}")
	public void deleteBookingById(@PathVariable int id)
	{
		bookingService.deleteBookingById(id);
	}
	
	@GetMapping("/getBookingByUserId/{id}")
	public List<Booking> getAllBooking(@PathVariable int id)
	{
		List<Booking> list=bookingService.findByUserId(id);
		return list;
		
	}
	
	@GetMapping("/getPendingRequest")
	public List<Booking> getPendingRequest()
	{
		List<Booking> list=bookingService.getAllBooking();
		list=list.stream().filter(i->(i.isApproved()==false &&i.isRejected==false)).collect(Collectors.toList());
		return list;
		
	}
	

	@GetMapping("/approvereq/{id}")
	public Booking getapprovereq(@PathVariable int id)
	{
		Booking b=bookingService.getBookingById(id);
		b.setApproved(true);
		b=bookingService.approverejectBooking(b);
		return b;
		
	}
	
	@GetMapping("/rejectreq/{id}")
	public Booking getrejectreq(@PathVariable int id)
	{
		Booking b=bookingService.getBookingById(id);
		b.setRejected(true);
		b=bookingService.approverejectBooking(b);
		return b;
		
		
	}
	

}

/*{
       "source":"pune",
       "destination":"nagpur",
       "startDate":"2022-12-11",
       "endDate":"2022-12-12"
       
       https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp
    }*/
