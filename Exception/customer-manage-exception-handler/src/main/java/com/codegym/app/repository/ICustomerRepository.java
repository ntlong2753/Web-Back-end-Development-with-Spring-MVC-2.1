package com.codegym.app.repository;

import com.codegym.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer, Long> {
}
