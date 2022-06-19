package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;
import com.techelevator.view.Stocker;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_CLOSE_OPTION = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_CLOSE_OPTION };
	private PurchaseMenu purchaseMenu = new PurchaseMenu();
	static Stocker stocker = new Stocker();
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean isRun = true;
		while (isRun) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				stocker.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				boolean isPurchase =true;
				while (isPurchase){

				 choice = (String) menu.getChoiceFromOptions(purchaseMenu.PURCHASE_MENU_OPTIONS(),purchaseMenu);
//				 System.out.println("Current Money Provided: $"+purchaseMenu.getCurrentMoney());
				 if (choice.equals(purchaseMenu.getPURCHASE_OPTION_FEED_MONEY())) {
					 boolean isFeed = true;
					 while (isFeed) {
						 choice = (String) menu.getChoiceFromOptions(purchaseMenu.FEED_MONEY_OPTIONS(), purchaseMenu);

						 if (!choice.equals(purchaseMenu.getPURCHASE_OPTION_FINISH_TRANSACTION())) {
							 purchaseMenu.feedMoney(Integer.parseInt(choice));
//
						 }
						 if (choice.equals(purchaseMenu.getPURCHASE_OPTION_FINISH_TRANSACTION())) {
							 isFeed = false;
						 }
					 }

				 } else if (choice.equals(purchaseMenu.getPURCHASE_OPTION_SELECT_PRODUCT())) {
					 choice = (String) purchaseMenu.getProductOption(purchaseMenu.productPurchasetoArray(stocker.getInventory()));
//					 Ask Sweet for suggestions to get this portion to work ^
				 } else if (choice.equals(purchaseMenu.getPURCHASE_OPTION_FINISH_TRANSACTION())) {
					 if(!purchaseMenu.getCurrentMoney().equals(0)) {
						 purchaseMenu.getChange();
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
