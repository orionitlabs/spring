package com.userservice.users.controller;

import com.userservice.users.model.CustomerVO;
import com.userservice.users.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/add-custmer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerVO addNewCustmer(@RequestBody CustomerVO customerVO) {
        return customerService.addNewCustomer(customerVO);
    }

    @GetMapping(path = "/get-customer-by-username", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerVO getCustomerByUserName(@RequestParam(required = true, defaultValue = "") String customerUserName) {
        return customerService.getCustomerByUsername(customerUserName);
    }

    @GetMapping(path = "/get-customer-by-email", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerVO getCustomerByEmail(@RequestParam(required = true, defaultValue = "") String customerEmail) {
        return customerService.getCustomerByEmail(customerEmail);
    }

    @GetMapping(path = "/get-customer-by-billno", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerVO getCustomerByBillNo(@RequestParam(required = true, defaultValue = "") String customerBillNo) {
        return customerService.getCustomerByBillNo(customerBillNo);
    }

}
