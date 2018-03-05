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
        if (availableItems.get(key) == null){
            System.out.println(key.getName() + " is not available as an item.");
        } else if (availableItems.get(key) == 0) {
            System.out.println(key.getName() + " is out of stock.");
        } else if (availableItems.get(key) < customerQuantity) {
            System.out.println("Only have " + availableItems.get(key) + " in stock of " + key.getName());
        } else {
            cart.put(key, customerQuantity);
            Integer itemCount = availableItems.get(key) - customerQuantity;
            availableItems.replace(key, itemCount);
        }
    }

    public void showCart() {
        this.cart.forEach((key, value) -> {
            System.out.printf(key.getName() + "\n" +
                    "\tPrice: " + "%.2f" + "\n" +
                    "\tQTY: " + value + "\n----------------\n", key.getPrice()
                );
        });
    }

    public Map<Product, Integer> getCart() {
        return this.cart;
    }

    public void showAvailableProducts() {
        this.availableItems.forEach((key, value) -> {
            System.out.println(key.getName() + "\tQTY: " + value);
        });
    }

    public Map<Product, Integer> getAvailableItems() {
        return availableItems;
    }

    public void removeItemFromCart (Product key){
        Integer quantityToAddBack = availableItems.get(key) + this.cart.get(key);
        availableItems.replace(key, quantityToAddBack);
        this.cart.remove(key);
    }

    public void checkout() {
        final Double[] total = {new Double(0)};
        this.cart.forEach((key, value) -> {
            System.out.printf(key.getName() + "\n" +
                    "\tPrice: " + "%.2f" + "\n" +
                    "\tQTY: " + value + "\n----------------\n", key.getPrice()
            );
            total[0] += key.getPrice() * value;
        });
        System.out.println(total[0]);
    }
}
