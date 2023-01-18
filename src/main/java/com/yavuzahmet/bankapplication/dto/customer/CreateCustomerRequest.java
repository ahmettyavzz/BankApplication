package com.yavuzahmet.bankapplication.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest extends BaseCustomerRequest{
    private String id;
}