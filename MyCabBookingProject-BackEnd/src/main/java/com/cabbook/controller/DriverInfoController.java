package com.cabbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbook.model.DriverInfo;
import com.cabbook.service.DriverInfoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/driver")
public class DriverInfoController {
	
	@Autowired
	public DriverInfoService driverService;
	
	@GetMapping("/findDriverInfoById/{id}")
	public DriverInfo findById(@PathVariable int id) {
     DriverInfo r= driverService.getDriverInfoById(id);
     return r;
    }

	@PostMapping("/addDriverInfo")
	public DriverInfo addDriverInfo(@Valid @RequestBody DriverInfo driver) {
		System.out.println("Inside add api "+driver);
		DriverInfo r=driverService.addDriverInfo(driver);
		return r;
	}
	
	@GetMapping("/getAllDriverInfo")
	public List<DriverInfo> getAllDriverInfo()
	{
		List<DriverInfo> list=driverService.getAllDriverInfo();
		return list;
		
	}
	@DeleteMapping("/deleteDriverInfoById/{id}")
	public void deleteDriverInfoById(@PathVariable int id) 
	{
		 driverService.deleteDriverInfoById(id);
	}
	@PutMapping("/updateDriverInfoById/{id}")
	public DriverInfo updateDriverInfoById(@RequestBody DriverInfo driver, @PathVariable int id )
	{
	return driverService.updateDriverInfoById(id, driver);	
	}
}
/*
{
"driverName":"rohan",
"mobileNo":"9988767876",
"driverDob":"1970-12-11",
"driverAdharNo":333456567876,
"driverAddress":"Pune",
"driverLicenceNo":"774456788",
"driverVehicleNo":"mh22345",
"vehicleName":"Swift",
"modelName":"UGX"


}
*/