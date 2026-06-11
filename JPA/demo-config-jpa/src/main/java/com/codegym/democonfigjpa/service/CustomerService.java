package com.codegym.democonfigjpa.service;

import com.codegym.democonfigjpa.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
