package com.cabbook.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Booking {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bookingId;

	@NotEmpty(message = "source can not be empty")
    private String source;
	
	@NotEmpty(message = "destination can not be empty")
    private String destination;
	
	//@NotEmpty(message = "startDate can not be empty")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
	
	//@NotEmpty(message = "endDate can not be empty")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "driverId_id")
	private DriverInfo driverId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reg_id")
	private Registration registrationId;
	
	private int userId;
	
	public boolean isApproved;
	
	public boolean isRejected;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public DriverInfo getDriverId() {
		return driverId;
	}

	public void setDriverId(DriverInfo driverId) {
		this.driverId = driverId;
	}

	public Registration getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Registration registrationId) {
		this.registrationId = registrationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
	public boolean isRejected() {
		return isRejected;
	}

	public void setRejected(boolean isRejected) {
		this.isRejected = isRejected;
	}



	public Booking(int bookingId, @NotEmpty(message = "source can not be empty") String source,
			@NotEmpty(message = "destination can not be empty") String destination, Date startDate, Date endDate,
			DriverInfo driverId, Registration registrationId, int userId, boolean isApproved, boolean isRejected) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.driverId = driverId;
		this.registrationId = registrationId;
		this.userId = userId;
		this.isApproved = isApproved;
		this.isRejected = isRejected;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", source=" + source + ", destination=" + destination
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", driverId=" + driverId + ", registrationId="
				+ registrationId + ", userId=" + userId + ", isApproved=" + isApproved + "]";
	}

	
}
