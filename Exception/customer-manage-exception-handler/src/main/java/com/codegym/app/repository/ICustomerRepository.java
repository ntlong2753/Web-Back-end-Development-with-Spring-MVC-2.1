package com.codegym.app.repository;

import com.codegym.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository  extends JpaRepository<Customer, Long> {
}
