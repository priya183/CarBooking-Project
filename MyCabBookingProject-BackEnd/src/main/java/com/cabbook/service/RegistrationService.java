package com.cabbook.service;

import java.util.List;

import com.cabbook.model.Registration;

public interface RegistrationService {
	
	public Registration findByEmailAddress(String username);
	 public Registration findById(long id);
	 public Registration findByEmailAddressAndPassword(String emailAddress,String password);
    public Registration addNewRegistration(Registration register);
	 public void deleteRegistration(long id);
	 public List<Registration> getAllRegistration();
	

}
