package com.yavuzahmet.bankapplication.converter;

import com.yavuzahmet.bankapplication.dto.CityDto;
import com.yavuzahmet.bankapplication.dto.account.AccountDto;
import com.yavuzahmet.bankapplication.dto.account.CreateAccountRequest;
import com.yavuzahmet.bankapplication.dto.account.UpdateAccountRequest;
import com.yavuzahmet.bankapplication.model.Account;
import com.yavuzahmet.bankapplication.model.City;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {

    public AccountDto accountToAccountDto(Account entity) {
        var dto = new AccountDto();
        dto.setId(entity.getId());
        dto.setCity(CityDto.valueOf(entity.getCity().name()));
        dto.setBalance(entity.getBalance());
        dto.setCurrency(entity.getCurrency());

        return dto;
    }

    public Account createAccountRequestToAccount(CreateAccountRequest request) {
        var account = new Account();
        account.setId(request.getId());
        account.setCity(City.valueOf(request.getCity().name()));
        account.setBalance(request.getBalance());
        account.setCurrency(request.getCurrency());

        return account;
    }

    public Account updateAccountRequestToAccount(UpdateAccountRequest request) {
        var account = new Account();
        account.setCity(City.valueOf(request.getCity().name()));
        account.setBalance(request.getBalance());
        account.setCurrency(request.getCurrency());

        return account;
    }
}