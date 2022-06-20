package com.techelevator.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stocker {
    private List<Product> inventory = new ArrayList<>();



    public void loadStock() {
        File file = new File("vendingmachine.csv");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String[] item = scan.nextLine().split("\\|");
                String code = item[0];
                String name = item[1];
                double price = Double.parseDouble(item[2]);
                String type = item[3];

                if (type.equals("Chip")) {
                    inventory.add(new Chips(code, name, price, type, 5 ) );
                }
                if (type.equals("Candy")) {
                    inventory.add(new Candy(code, name, price, type, 5 ) );
                }
                if (type.equals("Drink")) {
                    inventory.add(new Beverages(code, name, price, type, 5 ) );
                }
                if (type.equals("Gum")) {
                    inventory.add(new Gum(code, name, price, type, 5 ) );
                }

            }
        }
        catch(IOException ex) {
            System.out.println("File not found or invalid entry.");
        }
    }

    public void displayInventory() {

        for (int i = 0; i < inventory.size(); i+=4){
            String productColumn1 = inventory.get(i).getCode() + "| " + inventory.get(i).getName() + "| $" + inventory.get(i).getPrice();
            if (inventory.get(i).getQuantity() == 0) {
                productColumn1 += "| Out of Stock!";
            }
            String productColumn2 = inventory.get(i + 1).getCode() + "| " + inventory.get(i + 1).getName() + "| $" + inventory.get(i + 1).getPrice();
            if (inventory.get(i + 1).getQuantity() == 0) {
                productColumn2 += "| Out of Stock!";
            }
            String productColumn3 = inventory.get(i + 2).getCode() + "| " + inventory.get(i + 2).getName() + "| $" + inventory.get(i + 2).getPrice();
            if (inventory.get(i + 2).getQuantity() == 0) {
                productColumn3 += "| Out of Stock!";
            }
            String productColumn4 = inventory.get(i + 3).getCode() + "| " + inventory.get(i + 3).getName() + "| $" + inventory.get(i + 3).getPrice();
            if (inventory.get(i + 3).getQuantity() == 0) {
                productColumn4 += "| Out of Stock!";
            }
            System.out.printf("%-45s%-45s%-45s%-45s\n", productColumn1, productColumn2, productColumn3, productColumn4);

        }

    }


    public List<Product> getInventory() {
        return inventory;
    }




}
