package com.cabbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabbook.model.DriverInfo;
@Repository
public interface DriverInfoRepository extends JpaRepository<DriverInfo, Integer>{

}
