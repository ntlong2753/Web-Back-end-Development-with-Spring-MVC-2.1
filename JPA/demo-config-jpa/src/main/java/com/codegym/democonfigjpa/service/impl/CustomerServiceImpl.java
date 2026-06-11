package com.codegym.democonfigjpa.service.impl;

import com.codegym.democonfigjpa.model.Customer;
import com.codegym.democonfigjpa.repository.CustomerRepository;
import com.codegym.democonfigjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
