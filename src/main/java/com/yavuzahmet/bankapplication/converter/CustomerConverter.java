package com.yavuzahmet.bankapplication.converter;

import com.yavuzahmet.bankapplication.dto.CityDto;
import com.yavuzahmet.bankapplication.dto.customer.CreateCustomerRequest;
import com.yavuzahmet.bankapplication.dto.customer.CustomerDto;
import com.yavuzahmet.bankapplication.model.City;
import com.yavuzahmet.bankapplication.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer createCustomerRequestToCustomer(CreateCustomerRequest customerRequest) {
        var customer = new Customer();
        customer.setId(customerRequest.getId());
        customer.setName(customerRequest.getName());
        customer.setAddress(customerRequest.getAddress());
        customer.setCity(City.valueOf(customerRequest.getCity().name()));
        customer.setDateOfBirth(customerRequest.getDateOfBirth());

        return customer;
    }

    public CustomerDto customerToCustomerDto(Customer customer) {
        var customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setAddress(customer.getAddress());
        customerDto.setCity(CityDto.valueOf(customer.getCity().name()));
        customerDto.setDateOfBirth(customer.getDateOfBirth());

        return customerDto;
    }
}