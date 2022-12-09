package com.cabbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbook.model.Payment;
import com.cabbook.service.PaymentServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/payment")
public class PymentController {
	
	@Autowired
	private PaymentServiceImpl payService;
	
	@PostMapping("/addPayment")
	public Payment addPayemnt(@Valid @RequestBody Payment payment)
	{
		return payService.addPayment(payment);
	}
	@GetMapping("/getAllPayment")
	public List<Payment> getAllPayment()
	{
		return payService.getAllPayment();
	}
	@GetMapping("/getPaymentById/{id}")
	public Payment getPaymentById(@PathVariable int id)
	{
		return payService.getPaymentById(id);
	}
	
	

}
/*
  {
       "cardNumber":"9934567898765345",
       "expiryDate":"12-2022",
         "cvvNumber":"893"
    }
    */
