package com.cabbook.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbook.model.Registration;
import com.cabbook.service.RegistrationServiceImpl;


@CrossOrigin("*")
@RestController

@RequestMapping("/register")

public class RegistrationController {
   @Autowired
   public RegistrationServiceImpl registartionService;
   
   
   @PostMapping("/loginCustomer")  
   public Registration loginUser(@RequestBody Registration r) throws Exception
   {
       String logemailaddress=r.getEmailAddress();
       String logpassword=r.getPassword();
       
       Registration regobj = null;
       System.out.println(logemailaddress +" "+logpassword);
       
       if(logemailaddress !=null && logpassword !=null)
       {
           regobj =registartionService.findByEmailAddressAndPassword(logemailaddress,logpassword);
       }
       
       if(regobj.getEmailAddress().equals(logemailaddress) && regobj.getPassword().equals(logpassword) ) {
    	   return regobj;
       }
       else {
    	   return regobj;
       }
       
           //return r;
           
           
   }
   
   @GetMapping("/findByEmail/{emailAddress}")
	public Registration findByEmailAddress(@PathVariable String emailAddress) {
	   System.out.println("Inside find by email");
		return registartionService.findByEmailAddress(emailAddress);
	}

	@GetMapping("/findById/{id}")
	public Registration findById(@PathVariable long id) {
		Registration r= registartionService.findById(id);
		return r;
    }

	@PostMapping("/addRegistration")
	public Registration addNewRegistration(@Valid @RequestBody Registration register) {
		System.out.println("Inside add api "+register);
		Registration r=registartionService.addNewRegistration(register);
		return r;
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteRegistration(@PathVariable long id) {
		registartionService.deleteRegistration(id);
	}
	
	@GetMapping("/getAllRegistration")
	public List<Registration> getAll()
	{
		List<Registration> r=new ArrayList<>();
		r=registartionService.getAllRegistration();
		r=r.stream().filter(i->i.isAdmin()==false).collect(Collectors.toList());
		System.out.println("All Customers "+r);
		return r;
	}

	}

/*"userName":"priya",
    "emailAddress":"priya@gmail.com",
    "password":"priya123",
    "contactNo":"7788996656",
    "isAdmin":1
*/





