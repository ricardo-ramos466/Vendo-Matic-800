package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Product implements Purchasable {
    private String code;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity = 5;
    private int amountSold;

    //Constructors
    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.price = this.price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Product(String code, String name, double price, String type, int quantity) {
        this.code = code;
        this.name = name;
        this.price = new BigDecimal(price);
        this.price = this.price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.type = type;
        this.quantity = quantity;
    }
    //Create an abstract method to be used in child Classes
    abstract void purchaseThanks();

    //Overriding the sold method from Purchasable method to reduce quantity and add to amount sold
    @Override
    public void sold() {
        int soldCount = getAmountSold();
        int i = getQuantity();
        i--;
        soldCount++;
        setQuantity(i);
        setAmountSold(soldCount);
    }

    //override toString method to return in wanted format
    @Override
    public String toString() {
        return this.code + "|" + this.name + "|" + this.price;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
