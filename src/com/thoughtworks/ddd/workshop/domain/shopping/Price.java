package com.thoughtworks.ddd.workshop.domain.shopping;

import java.util.Currency;

public class Price {
    private Currency currency;
    private double price;

    public Price(Currency currency, double price) {
        this.currency = currency;
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getPrice() {
        return price;
    }
}
