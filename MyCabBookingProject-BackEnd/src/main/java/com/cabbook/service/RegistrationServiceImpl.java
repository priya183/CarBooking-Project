package com.cabbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cabbook.model.Registration;
import com.cabbook.repository.RegistrationRepository;
@Component
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRepository registerRepository;
   
	public Registration findByEmailAddressAndPassword(String logemailaddress, String logpassword)
	{
	Registration r=registerRepository.findByEmailAddressAndPassword(logemailaddress, logpassword);
	return r;
		
	}

	@Override
	public Registration findByEmailAddress(String emailAddress) {
		return registerRepository.findByEmailAddress(emailAddress);
	}

	@Override
	public Registration findById(long id) {
		Registration r= registerRepository.findById(id).get();
		return r;
     }

	@Override
	public Registration addNewRegistration(Registration register) {
		Registration r=registerRepository.save(register);
		return r;
	}

	@Override
	public void deleteRegistration(long id) {
		registerRepository.deleteById(id);
	}

	@Override
	public List<Registration> getAllRegistration() {
		List<Registration> list=registerRepository.findAll();
		return list;
	}
   
        
    }