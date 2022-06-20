package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;
import com.techelevator.view.Stocker;

import java.math.BigDecimal;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_CLOSE_OPTION = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_CLOSE_OPTION };
	private final PurchaseMenu Purchase_Menu = new PurchaseMenu();
	static Stocker stocker = new Stocker();
	private final Menu Main_Menu;

	public VendingMachineCLI(Menu menu) {
		this.Main_Menu = menu;
	}

	public void run() {
		boolean isRun = true;
		while (isRun) {
			String choice = (String) Main_Menu.getChoiceFromOptions(MAIN_MENU_OPTIONS, stocker.getInventory());

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				stocker.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				boolean isPurchase =true;
				while (isPurchase){

				 choice = (String) Main_Menu.getChoiceFromOptions(Purchase_Menu.PURCHASE_MENU_OPTIONS(),Purchase_Menu, stocker.getInventory());
//				 System.out.println("Current Money Provided: $"+purchaseMenu.getCurrentMoney());
				 if (choice.equals(Purchase_Menu.getPURCHASE_OPTION_FEED_MONEY())) {
					 boolean isFeed = true;
					 while (isFeed) {
						 choice = (String) Main_Menu.getChoiceFromOptions(Purchase_Menu.FEED_MONEY_OPTIONS(), Purchase_Menu, stocker.getInventory());

						 if (!choice.equals(Purchase_Menu.getPURCHASE_OPTION_FINISH_TRANSACTION())) {
							 Purchase_Menu.feedMoney(Integer.parseInt(choice));
//
						 }
						 if (choice.equals(Purchase_Menu.getPURCHASE_OPTION_FINISH_TRANSACTION())) {
							 isFeed = false;
						 }
					 }

				 } else if (choice.equals(Purchase_Menu.getPURCHASE_OPTION_SELECT_PRODUCT())) {
					 Purchase_Menu.getProductOption(stocker.getInventory());
				 } else if (choice.equals(Purchase_Menu.getPURCHASE_OPTION_FINISH_TRANSACTION())) {
					 if(!Purchase_Menu.getCurrentMoney().equals(new BigDecimal("0"))) {
						 Purchase_Menu.getChange();
					 }
					 isPurchase = false;
				 }

				}
			} else if (choice.equals(MAIN_MENU_CLOSE_OPTION)) {
				// exit application
				isRun = false;
			}
		}
		System.out.println("GoodBye!");
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		stocker.loadStock();
		cli.run();
	}
}
