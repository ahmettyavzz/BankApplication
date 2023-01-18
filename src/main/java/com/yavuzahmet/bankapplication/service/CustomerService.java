package com.yavuzahmet.bankapplication.service;

import com.yavuzahmet.bankapplication.converter.CustomerConverter;
import com.yavuzahmet.bankapplication.dto.customer.CustomerDto;
import com.yavuzahmet.bankapplication.dto.customer.UpdateCustomerRequest;
import com.yavuzahmet.bankapplication.model.City;
import com.yavuzahmet.bankapplication.model.Customer;
import com.yavuzahmet.bankapplication.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerDto createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customerConverter.customerToCustomerDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerConverter::customerToCustomerDto).collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(String id) {
        if (customerRepository.findById(id).isPresent()) {
            return customerConverter.customerToCustomerDto(customerRepository.findById(id).get());
        }
        return new CustomerDto();
    }

    public void deleteCustomer(String id) {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
        }
    }

    public CustomerDto updateCustomerById(String id, UpdateCustomerRequest customerRequest) {
        if (customerRepository.findById(id).isPresent()) {
            Customer toBeUpdatedData = customerRepository.findById(id).get();
            toBeUpdatedData.setName(customerRequest.getName());
            toBeUpdatedData.setCity(City.valueOf(customerRequest.getCity().name()));
            toBeUpdatedData.setAddress(customerRequest.getAddress());
            toBeUpdatedData.setDateOfBirth(customerRequest.getDateOfBirth());
            customerRepository.save(toBeUpdatedData);
            return customerConverter.customerToCustomerDto(toBeUpdatedData);
        } else {
            return null; //exception olmalı
        }
    }
}