package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PurchaseMenu extends Menu{

    private final static String PURCHASE_OPTION_FEED_MONEY = "Feed Money";
    private final static String PURCHASE_OPTION_SELECT_PRODUCT = "Select Product";
    private final static String PURCHASE_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private double currentMoney = 0;



    public PurchaseMenu(InputStream input, OutputStream output) {
        super(input, output);
    }

    public PurchaseMenu() {
        super();
    }

    public final String[] PURCHASE_MENU_OPTIONS() {
        String[] purchaseOptions = new String[] {PURCHASE_OPTION_FEED_MONEY, PURCHASE_OPTION_SELECT_PRODUCT, PURCHASE_OPTION_FINISH_TRANSACTION};

        return purchaseOptions;
    }

//    @Override
//    private void displayMenuOptions() {
//        out.println();
//        for (int i = 0; i < PURCHASE_MENU_OPTIONS().length; i++) {
//            int optionNum = i + 1;
//            out.println(optionNum + ") " + PURCHASE_MENU_OPTIONS()[i]);
//        }
//        out.print(System.lineSeparator() + "Please choose an option >>> ");
//        out.flush();
//    }

//    @Override
//    public Object getChoiceFromOptions(Object[] options) {
//        Object choice = null;
//        while (choice == null) {
//            displayMenuOptions();
//            choice = getChoiceFromUserInput(PURCHASE_MENU_OPTIONS());
//        }
//        return choice;
//    }

    public double feedMoney(int choiceSelected) {
        int moneyGiven = choiceSelected;
        currentMoney += moneyGiven;
        System.out.println("This is the current money provided: " + moneyGiven);
        return currentMoney;
    }

    public void selectProduct(String productCode) {

    }

    public final String[] FEED_MONEY_OPTIONS() {
        String[] billsToFeed = new String[] {"1", "2", "5", "10"};
        return billsToFeed;
    }

    public String[] productPurchase(List<Product> inventory) {
        String[] returnStatement = new String[inventory.size()];
        int i = 0;

        for (Product item : inventory) {
            returnStatement[i] = item.toString();
            i++;
        }
        return returnStatement;
    }

    public Product[] productPurchasetoArray(List<Product> inventory) {
        Product[] returnStatement = new Product[inventory.size()];
        int i = 0;

        for (Product item : inventory) {
            returnStatement[i] = item;
            i++;
        }
        return returnStatement;
    }

////    @Overloading the method
//    public void displayMenuOptions(String[] options) {
//        String[] productCode = new String[options.length];
//        String[] product = new String[options.length];
//        out.println();
//        for (int i = 0; i < options.length; i++) {
//            int optionNum = i + 1;
//            product = options[i].split("|");
//            productCode[i] = product[0];
//            out.println(productCode + ") " + product[1] + " $" + product[2]);
//        }
//        out.print(System.lineSeparator() + "Please choose an option >>> ");
//        out.flush();
//    }
//
    public void productList(Product[] products) {
        int i = 1;
        for (Product product : products) {
            if (i < 4) {
                System.out.print(product.getCode() + "| " + product.getName() + "| $" + product.getPrice() + "\t");
                i++;
            } else if (i == 4) {
                System.out.print(product.getCode() + "| " + product.getName() + "| $" + product.getPrice() + "\n");
                i = 1;
            }
        }
        System.out.print("Please select a product code >>> ");
        System.out.println(
        );
    }

    public Object getProductOption(Product[] options) {
        Object choice = null;
        while (choice == null) {
            productList(options);
            choice = ProductSelection(options);
        }
        return choice;

    }

//    private Object getChoiceFromUserInput(Product[] options) {
//        Scanner in = new Scanner(System.in);
//        Object choice = null;
//        String userInput = in.nextLine();
//        try {
//            for (Product option : options) {
//                if (option.getCode().equals(userInput)) {
//                    choice = option;
//                }
//            }
//        } catch (NumberFormatException e) {
//            // eat the exception, an error message will be displayed below since choice will be null
//        }
//        if (choice == null) {
//            System.out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
//        }
//        return choice;
//    }

    public Object ProductSelection(Product[] products) {
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine().toUpperCase();
        boolean isChoiceValid = false;
        for (Product product : products) {
            if (product.getCode().equals(choice) && product.getQuantity() > 0) {
                System.out.println("You have selected: " + product.getName() + ".");
                product.sold();
                isChoiceValid = true;
            } else if (product.getCode().equals(choice) && product.getQuantity() == 0) {
                System.out.println();
                System.out.println("The item that you have selected is out of stock.");
                isChoiceValid = true;
            }
        }
        if (!isChoiceValid) {
            System.out.println("The choice is invalid.");
        }
        return choice;
    }





    public String getPURCHASE_OPTION_FEED_MONEY() {
        return PURCHASE_OPTION_FEED_MONEY;
    }

    public String getPURCHASE_OPTION_SELECT_PRODUCT() {
        return PURCHASE_OPTION_SELECT_PRODUCT;
    }

    public String getPURCHASE_OPTION_FINISH_TRANSACTION() {
        return PURCHASE_OPTION_FINISH_TRANSACTION;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }
}
