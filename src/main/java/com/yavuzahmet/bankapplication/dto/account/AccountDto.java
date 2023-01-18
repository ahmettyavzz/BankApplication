package com.yavuzahmet.bankapplication.dto.account;

import com.yavuzahmet.bankapplication.dto.CityDto;
import com.yavuzahmet.bankapplication.model.Currency;
import com.yavuzahmet.bankapplication.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String id;
    private Customer customer;

    private Double balance;
    private CityDto city;
    private Currency currency;
}