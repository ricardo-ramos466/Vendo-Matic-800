package com.techelevator.view;

public abstract class Product implements Purchasable{
    private String code;
    private String name;
    private double price;
    private String type;
    private int quantity;


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String code, String name, double price, String type, int quanity){
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quanity;
    }

    void PurchaseThanks() {
    }



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

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        int i = getQuantity();
        i--;
        setQuantity(i);
    }
}
