package com.techelevator.view;

public class Chips extends Product {


    public Chips(String name, double price) {
        super(name, price);
    }

    public Chips(String code, String name, double price, String type, int quanity) {
        super(code, name, price, type, quanity);
    }
    @Override
    void purchaseThanks() {
        System.out.println("Crunch Crunch, Yum!");
    }
}