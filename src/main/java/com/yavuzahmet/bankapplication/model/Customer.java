package com.yavuzahmet.bankapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String Id;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;
    private String name;
    private Integer dateOfBirth;
    private City city;
    private String address;
}