package com.cabbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbook.model.DriverInfo;
import com.cabbook.repository.DriverInfoRepository;
@Service
public class DriverServiceInfoImpl implements DriverInfoService{
	
	@Autowired
	DriverInfoRepository driverInfoRepo;

	@Override
	public DriverInfo addDriverInfo(DriverInfo driver) {
		DriverInfo d =driverInfoRepo.save(driver);
		return d;
	}

	

	@Override
	public List<DriverInfo> getAllDriverInfo() {
		List<DriverInfo> list=driverInfoRepo.findAll();
		return list;
	}

	@Override
	public DriverInfo getDriverInfoById(int id) {
		DriverInfo d=driverInfoRepo.findById(id).get();
		return d;
	}
	@Override
	public DriverInfo updateDriverInfoById(int id, DriverInfo driver) 
	{
		Optional<DriverInfo> op=driverInfoRepo.findById(id);
		if(op.isPresent())
		{
			DriverInfo driverInfo=op.get();
			driverInfo.setDriverName(driver.getDriverName());
			driverInfo.setDriverAddress(driver.getDriverAddress());
			driverInfo.setDriverAdharNo(driver.getDriverAdharNo());
			driverInfo.setDriverDob(driver.getDriverDob());
			driverInfo.setMobileNo(driver.getMobileNo());
			driverInfo.setDriverVehicleNo(driver.getDriverVehicleNo());
			driverInfo.setVehicleName(driver.getDriverName());
			driverInfo.setDriverVehicleNo(driver.getDriverVehicleNo());
			driverInfo.setModelName(driver.getModelName());
			
			driverInfoRepo.save(driverInfo);
		}
		else
		{
			System.out.println("DriverInfo not available");
		}
		System.out.println("DriverInfo Updating Successfully ");
		return driver;
	}

	@Override
	public void deleteDriverInfoById(int id) 
	{
    DriverInfo book=new DriverInfo();
		
		try{
			
			book=getDriverInfoById(id);
			if(book!=null)
			{
				driverInfoRepo.deleteById(id);
				
			}
		}
		catch (Exception e) {
			System.out.println("Exception while removing DriverInfo");
		}
		System.out.println("DriverInfo deleted Successfully ");
	}



}
