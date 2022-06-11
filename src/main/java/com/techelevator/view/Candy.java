package com.techelevator.view;

public class Candy extends Product{
    public Candy(String name, double price) {
        super(name, price);
    }

    public Candy(String code, String name, double price, String type, int quanity) {
        super(code, name, price, type, quanity);
    }
}
