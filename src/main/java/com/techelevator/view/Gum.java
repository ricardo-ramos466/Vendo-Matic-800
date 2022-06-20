package com.techelevator.view;

public class Gum extends Product{
    public Gum(String name, double price) {
        super(name, price);
    }

    public Gum(String code, String name, double price, String type, int quantity) {
        super(code, name, price, type, quantity);
    }

    //Produces message after purchase
    @Override
    void purchaseThanks() {
        System.out.println("Chew Chew, Yum!");
    }
}
