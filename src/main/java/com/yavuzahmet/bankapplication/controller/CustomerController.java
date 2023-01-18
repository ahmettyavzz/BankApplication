package com.yavuzahmet.bankapplication.controller;

import com.yavuzahmet.bankapplication.converter.CustomerConverter;
import com.yavuzahmet.bankapplication.dto.customer.CreateCustomerRequest;
import com.yavuzahmet.bankapplication.dto.customer.CustomerDto;
import com.yavuzahmet.bankapplication.dto.customer.UpdateCustomerRequest;
import com.yavuzahmet.bankapplication.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerConverter customerConverter;

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.ok
                (customerService.createCustomer(customerConverter.createCustomerRequestToCustomer(createCustomerRequest)));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return ResponseEntity.ok(customerService.updateCustomerById(id, updateCustomerRequest));
    }
}
