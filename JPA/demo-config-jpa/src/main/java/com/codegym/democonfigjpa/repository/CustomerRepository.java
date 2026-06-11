package com.codegym.democonfigjpa.repository;

import com.codegym.democonfigjpa.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerRepository {
    List<Customer> findAll();
}
