package com.codegym.springbootcustomermanagement.repository;

import com.codegym.springbootcustomermanagement.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}
