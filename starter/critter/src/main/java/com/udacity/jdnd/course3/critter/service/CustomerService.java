package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer findById(long id){
        return customerRepository.findById(id).get();
    }
}
