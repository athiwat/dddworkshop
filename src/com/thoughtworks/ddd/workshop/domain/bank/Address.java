package com.thoughtworks.ddd.workshop.domain.bank;

public class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    protected void setCity(String city) {
        this.city = city;
    }
}
