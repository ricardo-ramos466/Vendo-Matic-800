package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Product implements Purchasable{
    private String code;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;
    private int amountSold;



    public Product(String name, double price) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.price = this.price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Product(String code, String name, double price, String type, int quanity){
        this.code = code;
        this.name = name;
        this.price = new BigDecimal(price);
        this.price = this.price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.type = type;
        this.quantity = quanity;
    }

    abstract void purchaseThanks();




    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return this.code + "|" + this.name + "|" + this.price;
    }

    @Override
    public void sold() {
        int soldCount= getAmountSold();
        int i = getQuantity();
        i--;
        soldCount++;
        setQuantity(i);
        setAmountSold(soldCount);
    }

    public int getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }
}
