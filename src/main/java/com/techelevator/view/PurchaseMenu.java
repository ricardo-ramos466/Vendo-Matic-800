package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PurchaseMenu extends Menu{

    private final static String PURCHASE_OPTION_FEED_MONEY = "Feed Money";
    private final static String PURCHASE_OPTION_SELECT_PRODUCT = "Select Product";
    private final static String PURCHASE_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private BigDecimal currentMoney = new BigDecimal(0);


    public PurchaseMenu() {
        super();
    }

    public final String[] PURCHASE_MENU_OPTIONS() {
        String[] purchaseOptions = new String[] {PURCHASE_OPTION_FEED_MONEY, PURCHASE_OPTION_SELECT_PRODUCT, PURCHASE_OPTION_FINISH_TRANSACTION};

        return purchaseOptions;
    }


    public BigDecimal feedMoney(int choiceSelected) {
        int moneyGiven = choiceSelected;
       BigDecimal moneyBefore = getCurrentMoney();
        setCurrentMoney(getCurrentMoney().add(new BigDecimal(moneyGiven)));
        String log ="FEED MONEY: $"+moneyBefore+"  $"+getCurrentMoney();
        machineLog(log);
        return getCurrentMoney();
    }


    public final String[] FEED_MONEY_OPTIONS() {
        String[] billsToFeed = new String[] {"1", "2", "5", "10", PURCHASE_OPTION_FINISH_TRANSACTION};
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

    public void productList(Product[] products) {
        int i = 0;
        for ( ; i < products.length; i += 4 ) {
            String productColumn1 = products[i].getCode() + "| " + products[i].getName() + "| $" + df.format(products[i].getPrice());
            if (products[i].getQuantity() == 0) {
                productColumn1 += "| Out of Stock!";
            }
            String productColumn2 = products[i + 1].getCode() + "| " + products[i + 1].getName() + "| $" + df.format(products[i + 1].getPrice());
            if (products[i + 1].getQuantity() == 0) {
                productColumn2 += "| Out of Stock!";
            }
            String productColumn3 = products[i + 2].getCode() + "| " + products[i + 2].getName() + "| $" + df.format(products[i + 2].getPrice());
            if (products[i + 2].getQuantity() == 0) {
                productColumn3 += "| Out of Stock!";
            }
            String productColumn4 = products[i + 3].getCode() + "| " + products[i + 3].getName() + "| $" + df.format(products[i + 3].getPrice());
            if (products[i + 3].getQuantity() == 0) {
                productColumn4 += "| Out of Stock!";
            }
            System.out.printf("%-45s%-45s%-45s%-45s\n", productColumn1, productColumn2, productColumn3, productColumn4);
        }

        System.out.println("\t Current Balance: $"+df.format(getCurrentMoney()));
        System.out.println();

        System.out.print("Please select a product code >>> ");
    }

    public Object getProductOption(Product[] options) {
        Object choice = null;
        while (choice == null) {
            productList(options);
            choice = ProductSelection(options);
            System.out.println();
        }
        return choice;

    }


    public Object ProductSelection(Product[] products) {
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine().toUpperCase();
        String log = "";
        BigDecimal moneyBefore;
        boolean isChoiceValid = false;
        for (Product product : products) {
            if (product.getCode().equals(choice) && product.getQuantity() > 0 && getCurrentMoney().compareTo(product.getPrice()) >= 0) {
                System.out.println("You have selected: " + product.getName() + " $" + product.getPrice()+ ".");
                product.sold();
                System.out.println();
                Dispensing();
                System.out.println();
                moneyBefore = getCurrentMoney();
                setCurrentMoney(getCurrentMoney().subtract(product.getPrice()));
                try {
                    Thread.sleep(500);
                    product.purchaseThanks();
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    System.err.println(e.getMessage());
                }
                log = product.getName() +" "+product.getCode()+ " $"+df.format(moneyBefore)+" $"+ getCurrentMoney();
                machineLog(log);
                isChoiceValid = true;
            } else if (product.getCode().equals(choice) && product.getQuantity() == 0 && getCurrentMoney().compareTo(product.getPrice()) >= 0 ) {
                System.out.println();
                System.out.println("The item that you have selected is out of stock.");
                isChoiceValid = true;

            } else if (product.getCode().equals(choice) && getCurrentMoney().compareTo(product.getPrice()) < 0 ) {
                System.out.println("Balance is too low!");
                isChoiceValid = true;
            }
        }
        if (!isChoiceValid) {
            System.out.println("The choice is invalid.");
        }
        return choice;
    }

    public void getChange(){
        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;
        BigDecimal dimeV = new BigDecimal(.10);
        dimeV = dimeV.setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal nickelV = new BigDecimal(.05);
        nickelV = nickelV.setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal quarterV = new BigDecimal(.25);
        quarterV = quarterV.setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal beforeMoney = getCurrentMoney();


        BigDecimal money = getCurrentMoney();

        String log = "";

        if (getCurrentMoney().compareTo(new BigDecimal(0)) > 0) {
            System.out.print("Dispensing: ");
        }
        while(getCurrentMoney().compareTo(quarterV) >= 0) {
            quarter++;
           setCurrentMoney(getCurrentMoney().subtract(quarterV));
            money = getCurrentMoney();
        }
        while(getCurrentMoney().compareTo(dimeV) >= 0) {
            dime++;
            setCurrentMoney(getCurrentMoney().subtract(dimeV));
            money = getCurrentMoney();
        }
        while (getCurrentMoney().compareTo(nickelV) >= 0) {
            nickel++;
            setCurrentMoney(getCurrentMoney().subtract(nickelV));
            money = getCurrentMoney();
        }

        if (quarter > 0) {
            System.out.print(quarter + " Quarter(s), ");
        }
        if (dime > 0) {
            System.out.print(dime + " Dime(s), ");
        }
        if (nickel > 0) {
            System.out.print(nickel + " Nickel(s) ");
        }

        log = "GIVE CHANGE: $"+ beforeMoney +" $"+getCurrentMoney();
        machineLog(log);
        System.out.println();
    }
    private void Dispensing(){
        System.out.print("Dispensing");
        try{
            for (int i = 0;i<3;i++){

                Thread.sleep(500);
                System.out.print(".");
            }
            Thread.sleep(500);
        }catch (InterruptedException e){
        System.err.println(e.getMessage());
    }
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

    public BigDecimal getCurrentMoney() {
        return currentMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
