package com.techelevator.view;

public class Beverages extends Product{
    public Beverages(String name, double price) {
        super(name, price);
    }

    public Beverages(String code, String name, double price, String type, int quanity) {
        super(code, name, price, type, quanity);
    }
    //Produces message after purchase
    @Override
    void purchaseThanks() {
        System.out.println("Glug Glug, Yum!");
    }
}
