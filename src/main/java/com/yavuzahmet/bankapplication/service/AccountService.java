package com.yavuzahmet.bankapplication.service;

import com.yavuzahmet.bankapplication.converter.AccountConverter;
import com.yavuzahmet.bankapplication.dto.account.AccountDto;
import com.yavuzahmet.bankapplication.model.Account;
import com.yavuzahmet.bankapplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;
    private final AccountConverter converter;

    public List<AccountDto> getAccounts() {
        return repository.findAll().stream().map(converter::accountToAccountDto).collect(Collectors.toList());
    }

    public AccountDto createAccount(Account account) {
        return converter.accountToAccountDto(repository.save(account));
    }

    public AccountDto getAccountById(String id) {
        if (repository.findById(id).isPresent()) {
            return converter.accountToAccountDto(repository.findById(id).get());
        } else {
            return null; //hata mesajı
        }
    }

    public AccountDto updateAccount(String id, Account forUpdateAccount) {
        if (repository.findById(id).isPresent()) {
            var account = new Account();
            account.setId(id);
            account.setBalance(forUpdateAccount.getBalance());
            account.setCity(forUpdateAccount.getCity());
            account.setCurrency(forUpdateAccount.getCurrency());
            repository.save(account);

            return converter.accountToAccountDto(account);
        } else {
            return new AccountDto();
        }
    }

    public void deleteAccount(String id) {
        repository.deleteById(id);
    }
}
