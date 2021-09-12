package com.thoughtworks.ddd.workshop.domain.bank;

public class Account {
    private Address address;

    public Account(Address address) {
        this.address = address;
    }

    protected void updateAddress(Address address) {
        this.address = address;
    }
}
