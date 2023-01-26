package com.yavuzahmet.bankapplication.dto.customer;

import com.yavuzahmet.bankapplication.dto.CityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCustomerRequest {
    private String customerId;
    private String name;
    private Integer dateOfBirth;
    private CityDto city;
    private String address;
}
