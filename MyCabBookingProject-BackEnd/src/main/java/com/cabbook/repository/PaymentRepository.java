package com.cabbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabbook.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
