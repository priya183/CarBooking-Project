package com.cabbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbook.model.Payment;
import com.cabbook.repository.PaymentRepository;
@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository payRepo;

	@Override
	public Payment addPayment(Payment payment) {
		Payment p=payRepo.save(payment);
		return p;
	}
	

	@Override
	public Payment getPaymentById(int id) {
		Payment p=payRepo.findById(id).get();
		return p;
	}

	@Override
	public List<Payment> getAllPayment() {
		List<Payment> list=payRepo.findAll();
		return list;
	}

	@Override
	public Payment updateBooking(int id, Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePaymentById(int d) {
		// TODO Auto-generated method stub
		
	}

}
