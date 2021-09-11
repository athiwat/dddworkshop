package com.thoughtworks.ddd.workshop.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> cart;
    private final ArrayList<Item> removeList;

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
}
