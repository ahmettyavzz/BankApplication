package com.yavuzahmet.bankapplication.controller;

import com.yavuzahmet.bankapplication.dto.CreateCustomerRequest;
import com.yavuzahmet.bankapplication.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        return null;
    }
}
