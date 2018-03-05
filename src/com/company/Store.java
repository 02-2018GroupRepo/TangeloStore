package com.company;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private Map<Product, Integer> cart;
    private Map<Product, Integer> availableItems;

    public Store() {
        this.cart = new HashMap<Product, Integer>();
        this.availableItems = new HashMap<Product, Integer>();
    }

    public void addToAvailableItems(Product key, Integer quantity) {
        availableItems.put(key, quantity);
    }

    public void addToCart(Product key, Integer customerQuantity) {
        if (availableItems.get(key) == null || availableItems.get(key) == 0) {
            System.out.println("Item out of stock.");
        } else if (availableItems.get(key) < customerQuantity) {
            System.out.println("Only have " + availableItems.get(key) + " in stock.");
        } else {
            this.cart.put(key, customerQuantity);
            Integer itemCount = availableItems.get(key) - customerQuantity;
            availableItems.replace(key, itemCount);
        }
    }

    public void getCart() {
        this.cart.forEach((key, value) -> {
            System.out.println(key.getName() + "\n" +
                    "\tPrice: " + key.getPrice() + "\n" +
                    "\tQTY: " + value + "\n----------------"
                );
        });
    }

    public void getAvailableProducts() {
        this.availableItems.forEach((key, value) -> {
            System.out.println(key.getName() + "\tQTY: " + value);
        });
    }

}
