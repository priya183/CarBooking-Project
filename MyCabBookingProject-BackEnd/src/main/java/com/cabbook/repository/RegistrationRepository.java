package com.cabbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabbook.model.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>{

	public Registration findByEmailAddressAndPassword(String logemailaddress, String logpassword);

	public Registration findByEmailAddress(String emailAddress);
	
	 

}
