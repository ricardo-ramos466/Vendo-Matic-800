package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
	public DecimalFormat df = new DecimalFormat("0.00");

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Menu() {

	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	public Object getChoiceFromOptions(Object[] options, List<Product> products) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options, products);
		}
		return choice;
	}


	public Object getChoiceFromOptions(Object[] options, PurchaseMenu menu, List<Product> products) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options, menu);
			choice = getChoiceFromUserInput(options, products);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options, List<Product> products) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			} else if (selectedOption == 4) {
				salesReport(products);
				choice = "not null";
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	private void displayMenuOptions(Object[] options, PurchaseMenu menu) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}

		out.print(System.lineSeparator() + "Current Money Provided: $" + df.format(menu.getCurrentMoney()) + "\n" + "Please choose an option >>> ");
		out.flush();
	}
	public void machineLog(String log){
		File logFile = new File("log.txt");
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		Date date = new Date();
		try(PrintWriter logger = new PrintWriter(new FileOutputStream(logFile,true))){

			logger.println(formatDate.format(date)+"\t"+log);


		}catch (Exception e){

		}
	}

	public void salesReport(List<Product> products) {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss_aa");
		Date date = new Date();
		String currentDate = formatDate.format(date);
		String filePath = currentDate + "_salesReport.txt";
		File salesReportFile = new File(filePath);


		try(PrintWriter logger = new PrintWriter(salesReportFile)){
			for (Product product : products) {
				logger.println(product.getName() + "| " + product.getAmountSold());
			}

		}catch (Exception e){
			e.printStackTrace();

		}
	}
}
