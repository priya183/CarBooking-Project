package com.cabbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cabbook.model.Booking;
import com.cabbook.model.DriverInfo;
@Service
public interface DriverInfoService {
	
	public DriverInfo addDriverInfo(DriverInfo driver);
	public DriverInfo getDriverInfoById(int id);
	List<DriverInfo> getAllDriverInfo();
	public DriverInfo updateDriverInfoById(int id, DriverInfo driver);
	public void deleteDriverInfoById(int id);
	}
