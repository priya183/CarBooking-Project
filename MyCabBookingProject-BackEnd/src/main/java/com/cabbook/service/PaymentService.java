package com.cabbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cabbook.model.Payment;
@Service
public interface PaymentService {
   
	public Payment addPayment(Payment payment);
	public Payment getPaymentById(int id);
	public List<Payment> getAllPayment();
	public Payment updateBooking(int id,Payment payment);
	public void deletePaymentById(int d);
	

}
