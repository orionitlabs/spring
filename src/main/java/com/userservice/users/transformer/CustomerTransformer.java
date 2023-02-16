package com.userservice.users.transformer;

import com.userservice.users.entity.CustomerEntity;
import com.userservice.users.model.CustomerVO;
import com.userservice.users.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer {
    @Autowired
    Utils utils;
    public CustomerEntity toCustomerEntity(CustomerVO customerVO){
        return CustomerEntity.builder()
                .customerFirstName(customerVO.getCustomerFirstName())
                .customerLastName(customerVO.getCustomerLastName())
                .customerUserName(utils.createCustomerUserName(customerVO.getCustomerFirstName(), customerVO.getCustomerLastName()))
                .customerBillNo(customerVO.getCustomerBillNo())
                .customerEmail(customerVO.getCustomerEmail())
                .build();
    }
    public CustomerVO fromCustomerEntity(CustomerEntity customerEntity){
        return CustomerVO.builder()
                .customerFirstName(customerEntity.getCustomerFirstName())
                .customerLastName(customerEntity.getCustomerLastName())
                .customerUserName(customerEntity.getCustomerUserName())
                .customerBillNo(customerEntity.getCustomerBillNo())
                .customerEmail(customerEntity.getCustomerEmail())
                .build();
    }
}

