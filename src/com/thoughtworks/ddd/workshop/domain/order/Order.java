package com.thoughtworks.ddd.workshop.domain.order;

import com.thoughtworks.ddd.workshop.domain.service.ProductWeight;
import com.thoughtworks.ddd.workshop.domain.service.ShippingCostCalculator;
import com.thoughtworks.ddd.workshop.domain.shopping.Cart;
import com.thoughtworks.ddd.workshop.domain.shopping.Product;

import java.util.List;

public class Order {
    private Cart cart;
    private double productPrice;
    private double shippingCost;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void checkout() {
        this.productPrice = cart.chekout();
        List<Product> products = cart.getProducts();
        double totalWeight = new ProductWeight().calculateWeight(products);
        this.shippingCost = new ShippingCostCalculator().calculate(totalWeight);
    }

    public double totalPrice() {
        return productPrice + shippingCost;
    }

}
