package com.thoughtworks.ddd.workshop.domain.service;

public class ShippingCostCalculator {
    public double calculate(double totalWeight) {
        return totalWeight * 0.1;
    }
}
