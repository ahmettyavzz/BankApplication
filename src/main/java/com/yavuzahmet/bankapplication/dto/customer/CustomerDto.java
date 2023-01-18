package com.yavuzahmet.bankapplication.dto.customer;

import com.yavuzahmet.bankapplication.dto.CityDto;
import com.yavuzahmet.bankapplication.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String id;
    private List<Account> accounts;
    private String name;
    private Integer dateOfBirth;
    private CityDto city;
    private String address;
}