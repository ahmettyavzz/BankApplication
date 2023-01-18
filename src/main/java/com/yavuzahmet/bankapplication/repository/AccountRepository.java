package com.yavuzahmet.bankapplication.repository;

import com.yavuzahmet.bankapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}