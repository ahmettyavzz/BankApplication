package com.yavuzahmet.bankapplication.dto.account;

import com.yavuzahmet.bankapplication.dto.CityDto;
import com.yavuzahmet.bankapplication.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseAccountRequest {
    private String customerId;
    private Double balance;
    private CityDto city;
    private Currency currency;
}