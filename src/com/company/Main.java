package com.company;

public class Main {

    public static void main(String[] args) {
        Store homeDepot = new Store();
        Product hammer = new Product ("Hammer", "Heavy metal head and plastic handle.", 7);
        Product drill = new Product ("Drill", "An electrical tool with a metal component.", 29.99);
        Product flathead = new Product ("Flat Head Screw Driver", "Tool used with a flat head.", 4.99);
        Product philipshead = new Product ("Philips Head Screw Driver", "Tool with star shaped head.", 4.99);
        Product ruler = new Product ("Ruler", "Measurement tool.", 2.99);
        //Craftsmen Products
        Product nut = new Product ("nut", "cylindrical device", .50);
        Product bolt = new Product ("bolt", "elongated iron for tightening", .75);
        Product screw = new Product ("screw", "spiral piece of iron for tightening", .20);
        Product washer = new Product ("washer", "circular piece of metal for fastening", .60);
        Product gasket = new Product ("gasket", "rubber item used for water proofing", .55);
        //John Deer Products
        Product trailer = new Product ("Trailer", "Empty space object used for storage", 500.00);
        Product pushLawnMower = new Product ("Push Lawn Mower", "Grass cutting device", 675.00);
        Product weedWacker = new Product ("Weed Wacker", "Battery operated device  for trimming", 67.00);
        Product shrubTrimmer = new Product ("Scrub Trimmer", "Device used to trim scrubs", 90.00);
        Product rake = new Product ("Rake", "Plastic or metal tool for collecting debris", 34.00);

        Product productArray[] = {hammer, drill, flathead, philipshead, ruler};
        for (Product product: productArray) {
            homeDepot.addToAvailableItems(product, 5);
        }
//        homeDepot.addToAvailableItems(rake, 0);
//        homeDepot.getAvailableProducts();
        homeDepot.addToCart(hammer, 2);
        homeDepot.addToCart(drill, 3);
        homeDepot.addToCart(flathead, 6);
        homeDepot.addToCart(rake, 3);
        homeDepot.getCart();
    }
}
