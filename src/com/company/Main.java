package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Store homeDepot = new Store();
        Product hammer = new Product("Hammer", "Heavy metal head and plastic handle.", 7);
        Product drill = new Product("Drill", "An electrical tool with a metal component.", 29.99);
        Product flathead = new Product("Flat Head Screw Driver", "Tool used with a flat head.", 4.99);
        Product philipshead = new Product("Philips Head Screw Driver", "Tool with star shaped head.", 4.99);
        Product ruler = new Product("Ruler", "Measurement tool.", 2.99);
        //Craftsmen Products
        Product nut = new Product("nut", "cylindrical device", .50);
        Product bolt = new Product("bolt", "elongated iron for tightening", .75);
        Product screw = new Product("screw", "spiral piece of iron for tightening", .20);
        Product washer = new Product("washer", "circular piece of metal for fastening", .60);
        Product gasket = new Product("gasket", "rubber item used for water proofing", .55);
        //John Deer Products
        Product trailer = new Product("Trailer", "Empty space object used for storage", 500.00);
        Product pushLawnMower = new Product("Push Lawn Mower", "Grass cutting device", 675.00);
        Product weedWacker = new Product("Weed Wacker", "Battery operated device  for trimming", 67.00);
        Product shrubTrimmer = new Product("Scrub Trimmer", "Device used to trim scrubs", 90.00);
        Product rake = new Product("Rake", "Plastic or metal tool for collecting debris", 34.00);

        Product productArray[] = {hammer, drill, flathead, philipshead, ruler};
        for (Product product : productArray) {
            homeDepot.addToAvailableItems(product, 5);
        }

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            homeDepot.showAvailableProducts();
            boolean inputContinue = true;
            do {
                System.out.print("Cart options:" + "\n" +
                        "1 to view contents of the cart" + "\n" +
                        "2 to add product to your cart" + "\n" +
                        "3 to remove product from your cart" + "\n" +
                        "4 to checkout" + "\n");
                int inputOptions = Integer.parseInt(console.readLine());
                switch (inputOptions) {
                    case 1:
                        homeDepot.showCart();
                        break;
                    case 2: {
                        System.out.println("");
                        System.out.println("Which items do you want to add to your cart?\n");
                        String inputKey = console.readLine();

                        System.out.println("How many do you want of this item?");
                        Integer inputValue = Integer.valueOf(console.readLine());
                        homeDepot.getAvailableItems().forEach((key, value) -> {
                            if (key.getName().equalsIgnoreCase(inputKey)) {
                                homeDepot.addToCart(key, inputValue);
                            }
                        });
                    }
                        break;
                    case 3: {
                        System.out.println("");
                        System.out.println("Which items do you want to remove from your cart?\n");
                        String inputKey = console.readLine();
                        Product productToDelete = new Product();
                        for (Map.Entry<Product, Integer> entry : homeDepot.getCart().entrySet()) {
                            if (entry.getKey().getName().equalsIgnoreCase(inputKey)) {
                                productToDelete = entry.getKey();
                            }
                        }
                        homeDepot.removeItemFromCart(productToDelete);
                    }
                        break;
                    case 4:
                        homeDepot.checkout();
                        inputContinue = false;
                        break;
                }
            }
            while (inputContinue);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                console.close();
            } catch (Exception e) {
            }
            console = null;
        }
    }
}
