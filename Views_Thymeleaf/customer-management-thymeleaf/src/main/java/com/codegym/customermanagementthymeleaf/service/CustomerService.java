package com.codegym.customermanagementthymeleaf.service;

import com.codegym.customermanagementthymeleaf.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Jayce", "jayce@codegym.vn", "Top lane"));
        customers.put(2, new Customer(2, "xinzhao", "xinzhao@codegym.vn", "jungle"));
        customers.put(3, new Customer(3, "Yasuo", "yasuo@codegym.vn", "Mide lane"));
        customers.put(4, new Customer(4, "Jinx", "lucian@codegym.vn", "Adc bot lane"));
        customers.put(5, new Customer(5, "Nautilus", "nautilus@codegym.vn", "Support Bot lane"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}