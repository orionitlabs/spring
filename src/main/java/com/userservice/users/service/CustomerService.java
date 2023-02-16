package com.userservice.users.service;

import com.userservice.users.entity.CustomerEntity;
import com.userservice.users.model.CustomerVO;
import com.userservice.users.repository.CustomerRepository;
import com.userservice.users.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerTransformer customerTransformer;

    public CustomerVO addNewCustomer(CustomerVO customerVO) {
        return customerTransformer.fromCustomerEntity(customerRepository.save(customerTransformer.toCustomerEntity(customerVO)));
    }

    public CustomerVO getCustomerByUsername(String customerUserName) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerUserName(customerUserName);
        if (customer.isPresent()) {
            return customerTransformer.fromCustomerEntity(customer.get());
        } else {
            throw new RuntimeException("Customer is not present");
        }
    }

    public CustomerVO getCustomerByEmail(String customerEmail) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerEmail(customerEmail);
        if (customer.isPresent()) {
            return customerTransformer.fromCustomerEntity(customer.get());
        } else {
            throw new RuntimeException("Customer is not present");
        }
    }

    public CustomerVO getCustomerByBillNo(String customerBillNo) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerBillNo(customerBillNo);
        if (customer.isPresent()) {
            return customerTransformer.fromCustomerEntity(customer.get());
        } else {
            throw new RuntimeException("Customer is not present");
        }
    }

}

