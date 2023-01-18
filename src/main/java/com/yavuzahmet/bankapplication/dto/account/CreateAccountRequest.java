package com.yavuzahmet.bankapplication.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest extends BaseAccountRequest {
    private String id;
}