package com.thoughtworks.ddd.workshop.domain.bank;

import java.util.List;

public class Customer {
    private Address address;
    private final List<Account> accounts;

    public Customer(Address address, List<Account> accounts) {
        this.address = address;
        this.accounts = accounts;
    }

    public void updateAddress(Address address) {
        this.address = address;
        for (Account account : accounts) {
            account.updateAddress(address);
        }
    }
    

}
