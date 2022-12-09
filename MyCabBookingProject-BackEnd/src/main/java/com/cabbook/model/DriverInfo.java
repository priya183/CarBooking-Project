package com.cabbook.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DriverInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int driverId;
	
    @NotEmpty(message = "driver name can not be empty")
	public String driverName;
    
 
   // @NotEmpty(message = "mobile number can not be empty")
    @Size(min = 10,max= 10, message = "contact_no should be exact 10 characters." )
	public String mobileNo;
    
    @JsonFormat(pattern="yyyy-MM-dd")
	public Date driverDob;
    
    
    //@NotEmpty(message = "adhar number can not be empty")
    @Size(min = 12,max= 12, message = "adhar_no should be exact 10 characters." )
	public String driverAdharNo;
    
    @NotEmpty(message = "address can not be empty")
	public String driverAddress;
    
  
    @NotEmpty(message = "licence number can not be empty")
	public String driverLicenceNo;
    
   
    @NotEmpty(message = "vehicle number can not be empty")
	public String driverVehicleNo;
    
    @NotEmpty(message = "vehicle name can not be empty")
    public String vehicleName;
    
    @NotEmpty(message = "model name can not be empty")
    public String modelName;
    
    public int price;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDriverDob() {
		return driverDob;
	}

	public void setDriverDob(Date driverDob) {
		this.driverDob = driverDob;
	}

	public String getDriverAdharNo() {
		return driverAdharNo;
	}

	public void setDriverAdharNo(String driverAdharNo) {
		this.driverAdharNo = driverAdharNo;
	}

	public String getDriverAddress() {
		return driverAddress;
	}

	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}

	public String getDriverLicenceNo() {
		return driverLicenceNo;
	}

	public void setDriverLicenceNo(String driverLicenceNo) {
		this.driverLicenceNo = driverLicenceNo;
	}

	public String getDriverVehicleNo() {
		return driverVehicleNo;
	}

	public void setDriverVehicleNo(String driverVehicleNo) {
		this.driverVehicleNo = driverVehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public DriverInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverInfo(int driverId, @NotEmpty(message = "driver name can not be empty") String driverName,
			@Size(min = 10, max = 10, message = "contact_no should be exact 10 characters.") String mobileNo,
			Date driverDob,
			@Size(min = 12, max = 12, message = "adhar_no should be exact 10 characters.") String driverAdharNo,
			@NotEmpty(message = "address can not be empty") String driverAddress,
			@NotEmpty(message = "licence number can not be empty") String driverLicenceNo,
			@NotEmpty(message = "vehicle number can not be empty") String driverVehicleNo,
			@NotEmpty(message = "vehicle name can not be empty") String vehicleName,
			@NotEmpty(message = "model name can not be empty") String modelName, int price) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.mobileNo = mobileNo;
		this.driverDob = driverDob;
		this.driverAdharNo = driverAdharNo;
		this.driverAddress = driverAddress;
		this.driverLicenceNo = driverLicenceNo;
		this.driverVehicleNo = driverVehicleNo;
		this.vehicleName = vehicleName;
		this.modelName = modelName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "DriverInfo [driverId=" + driverId + ", driverName=" + driverName + ", mobileNo=" + mobileNo
				+ ", driverDob=" + driverDob + ", driverAdharNo=" + driverAdharNo + ", driverAddress=" + driverAddress
				+ ", driverLicenceNo=" + driverLicenceNo + ", driverVehicleNo=" + driverVehicleNo + ", vehicleName="
				+ vehicleName + ", modelName=" + modelName + ", price=" + price + "]";
	}
    

}