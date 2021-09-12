package com.thoughtworks.ddd.workshop.domain.shopping;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> cart;
    private final ArrayList<Item> removeList;
    private boolean checkout = false;
    private double productPrice;

    public Cart() {
        cart = new ArrayList<Item>();
        removeList = new ArrayList<Item>();
    }

    void add(Item item) {
        cart.add(item);
    }

    List<Item> list() {
        return cart;
    }

    void remove(String productName) {
        for (int i = cart.size()-1; i >=0 ; i--) {
            Item item = cart.get(i);
            if(item.getProduct().getName().contentEquals(productName)) {
                removeList.add(item);
                cart.remove(item);
            }
        }
    }

    public List<Item> getRemoveList() {
        return removeList;
    }

    public double chekout() {
        this.checkout = true;
        return calculateTotalPrice();
    }

    protected double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : getProducts()) {
            totalPrice += product.getPrice().getPrice();
        }
        return totalPrice;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (Item item : cart) {
            for (int i = 0; i < item.getQuantity(); i++) {
                products.add(item.getProduct());
            }
        }
        return products;
    }
}
