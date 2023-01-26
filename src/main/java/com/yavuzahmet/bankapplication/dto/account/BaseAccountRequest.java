package com.yavuzahmet.bankapplication.dto.account;

import com.yavuzahmet.bankapplication.dto.CityDto;
import com.yavuzahmet.bankapplication.model.Currency;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseAccountRequest {

    @NotNull(message = "CustomerId can not null!")
    private String customerId;

    @NotNull(message = "Balance can not null!")
    @Min(0)
    private Double balance;

    @NotNull(message = "City can not null!")
    private CityDto city;

    @NotNull(message = "Currency can not null!")
    private Currency currency;
}