package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PurchaseMenu extends Menu{

    private final static String PURCHASE_OPTION_FEED_MONEY = "Feed Money";
    private final static String PURCHASE_OPTION_SELECT_PRODUCT = "Select Product";
    private final static String PURCHASE_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private double currentMoney = 0;
    private PrintWriter out;

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

    public double feedMoney(int moneyGiven) {
        currentMoney += moneyGiven;

        return currentMoney;
    }

    public final String[] FEED_MONEY_OPTIONS() {
        String[] billsToFeed = new String[] {"$1", "$2", "$5", "$10"};
        return billsToFeed;
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
