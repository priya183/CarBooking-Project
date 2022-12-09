package com.cabbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Payment {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int paymentId;
	@Size(min = 16,max= 16, message = "contact_no should be exact 16 characters." )
	private String cardNumber;
	//@JsonFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="MM-yyyy")
	private String expiryDate;
	@Size(min = 3,max= 3, message = "contact_no should be exact 3 characters." )
	private String cvvNumber;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public Payment(int paymentId,
			@Size(min = 16, max = 16, message = "contact_no should be exact 10 characters.") String cardNumber,
			String expiryDate,
			@Size(min = 3, max = 3, message = "contact_no should be exact 10 characters.") String cvvNumber) {
		super();
		this.paymentId = paymentId;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvvNumber = cvvNumber;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate
				+ ", cvvNumber=" + cvvNumber + "]";
	}
	


}
