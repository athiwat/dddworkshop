package com.thoughtworks.ddd.workshop.domain.shopping;

import com.thoughtworks.ddd.workshop.domain.shopping.Cart;
import com.thoughtworks.ddd.workshop.domain.shopping.Item;
import com.thoughtworks.ddd.workshop.domain.shopping.Price;
import com.thoughtworks.ddd.workshop.domain.shopping.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void addOneItem() {
        cart.add(new Item(new Product("product", new Price(Currency.getInstance("USD"), 10)), 1));

        List<Item> cartList = cart.list();
        assertEquals(cartList.size(), 1);
        assertEquals(cartList.get(0).getProduct().getName(),"product");
        assertEquals(cartList.get(0).getQuantity(),1);
    }

    @Test
    void addTwoItem() {
        cart.add((new Item(new Product("p1" , new Price(Currency.getInstance("USD"), 10)),2)));
        cart.add((new Item(new Product("p2" , new Price(Currency.getInstance("USD"), 20)),3)));


        List<Item> cartlist = cart.list();
        assertEquals(cartlist.size(), 2);
        Item item1 = cartlist.get(0);
        assertEquals(item1.getProduct().getName(), "p1");
        assertEquals(item1.getQuantity(), 2);

        Item item2 = cartlist.get(1);
        assertEquals(item2.getProduct().getName(), "p2");
        assertEquals(item2.getQuantity(), 3);
    }

    @Test
    void removeItemByProductName() {
        cart.add((new Item(new Product("p1", new Price(Currency.getInstance("USD"), 10)),2)));
        cart.add((new Item(new Product("p2", new Price(Currency.getInstance("USD"), 10)),3)));

        cart.remove("p1");

        assertEquals(cart.list().size(),1);
    }

    @Test
    void removeAllItemsByProductName() {
        cart.add((new Item(new Product("p1", new Price(Currency.getInstance("USD"), 10)),2)));
        cart.add((new Item(new Product("p1", new Price(Currency.getInstance("USD"), 10)),3)));

        cart.remove("p1");

        assertEquals(0, cart.list().size());
    }

    @Test
    void logRemoveItems() {
        cart.add((new Item(new Product("p1", new Price(Currency.getInstance("USD"), 10)),2)));
        cart.add((new Item(new Product("p1", new Price(Currency.getInstance("USD"), 10)),3)));

        cart.remove("p1");

        assertEquals(2, cart.getRemoveList().size());
    }

    @Test
    void nonEqualItem() {
        cart.add((new Item(new Product("p1", new Price(Currency.getInstance("USD"), 10)),2)));
        Cart cart2 = new Cart();
        cart2.add((new Item(new Product("p1", new Price(Currency.getInstance("USD"), 10)),2)));


        assertFalse(cart.equals(cart2));
    }
}