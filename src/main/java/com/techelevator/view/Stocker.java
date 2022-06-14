package com.techelevator.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stocker {
    private List<Product> inventory = new ArrayList<>();



    public void loadStock() {
        File file = new File("C:\\Users\\music\\Desktop\\Sus Tech Squad\\capstone-1\\vendingmachine.csv");
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
            System.out.println("Heeelp");
        }
    }

    public void displayInventory() {
        String returnStatement = "0";

        for (Product item : inventory) {
            returnStatement = item.toString();
            System.out.println(returnStatement);
        }

    }


    public List<Product> getInventory() {
        return inventory;
    }




}
