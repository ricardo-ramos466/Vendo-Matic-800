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
				 choice = (String) purchaseMenu.getChoiceFromOptions();
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
