package com.yavuzahmet.bankapplication.dto.account;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest extends BaseAccountRequest {
    @NotBlank(message = "Account id not blank!")
    private String id;
}