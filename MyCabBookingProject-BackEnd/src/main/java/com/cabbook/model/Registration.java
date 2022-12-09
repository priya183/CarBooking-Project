package com.cabbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
@Entity
public class Registration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long registrationId;
	
	@NotEmpty(message = "name must not be empty")
    private String userName;
	
    @Column(unique = true)
    @Email
    private String emailAddress;
   
   
    @NotEmpty(message = "password can not be empty")
	@Size(min=4, max=10,message="password should be minimum of 4 and maximum of 10 characters.")
	private String password;
    
   // @NotEmpty(message = "contact number must not be empty")
    @Size(min = 10,max= 10, message = "contact_no should be exact 10 characters." )
    private String contactNo;
   
	private boolean isAdmin;

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Registration(long registrationId, @NotEmpty(message = "name must not be empty") String userName,
			@Email String emailAddress,
			@UniqueElements @NotEmpty(message = "password can not be empty") @Size(min = 4, max = 10, message = "password should be minimum of 4 and maximum of 10 characters.") String password,
			@NotEmpty(message = "contact number must not be empty") String contactNo,
			@NotEmpty(message = "isAdmin can not be empty") boolean isAdmin) {
		super();
		this.registrationId = registrationId;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.contactNo = contactNo;
		this.isAdmin = isAdmin;
	}

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Registration [registrationId=" + registrationId + ", userName=" + userName + ", emailAddress="
				+ emailAddress + ", password=" + password + ", contactNo=" + contactNo + ", isAdmin=" + isAdmin + "]";
	}
    
	

}
