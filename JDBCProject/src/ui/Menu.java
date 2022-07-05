package ui;

import java.util.Scanner;

public class Menu {

	String username;
	String password;

	Scanner sc = new Scanner(System.in);

	// Creating objects of relevant UI objects
	AddRecrodUI add = new AddRecrodUI();
	DeleteRecordUI del = new DeleteRecordUI();
	GetRecordUI get = new GetRecordUI();
	ReportUI report = new ReportUI();
	UpdateRecordUI update = new UpdateRecordUI();

	// Display logInHeader
	public void logInHeader() {
		System.out.println("\t\t\t******* Welcome to School Management System ******");
		System.out.println("\t\t\t\t***********************************");
	}

	// User Validation
	public void validateUser() {
		System.out.println("\n\t\t\tEnter your username and password to login.");
		System.out.print("\n\t\t\tUsername :");
		username = sc.nextLine();
		System.out.print("\t\t\tPassword :");
		password = sc.nextLine();

		UserValidation login = new UserValidation(username, password);

		if (login.checkPassword())

			System.out.println("\n\t\t\tLogging you in....\n\t\t\tYou are logged in now.");
		else {
			clearScreen();
			System.out.println("\n\t\t\tUsername or password is invalid.\n");

			validateUser();

		}
	}

	// Display Main Menu
	public void displayMainMenu() {
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("\t\t*************** MAIN MENU ***************\n");
			System.out.println("\t\t\t[1] ADD\t\t[2] UPDATE");
			System.out.println("\t\t\t[3] DELETE\t[4] SEARCH");
			System.out.println("\t\t\t[5] REPORT\t[6] EXIT");

			int choice = -1;
			System.out.print("\n\t\t\tEnter a valid number for your choice: ");
			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {

			case 1:
				addRecordSubMenu();
				break;

			case 2:
				updateRecordSubMenu();
				break;

			case 3:
				deleteRecordSubMenu();
				break;

			case 4:
				findRecordSubMenu();
				break;

			case 5:
				displayAllRecordsSubMenu();
				break;

			case 6:
				clearScreen();
				System.out.println("\t\t\tTHANK YOU FOR YOUR TIME. SEE YOU AGAIN.\n\n\n\n\n");
				isRunning = false;
				System.exit(0);
				break;

			default:
				System.out.println("\n\t\t\tInvalid Key.");
				pressEnterToContinue();
				clearScreen();
				displayMainMenu(); // recursive function
				break;
			}
		}
	}

	// Add Record Sub Menu
	public void addRecordSubMenu() {

		int ch = -1;
		boolean isRunning = true;
		while (isRunning) {
			clearScreen();
			System.out.println("\t\t\t****** ADD RECORD ******\n\n");

			displaySubMenuHeaders();

			System.out.print("\n\t\t\tEnter your choice : ");

			ch = Integer.parseInt(sc.nextLine());

			switch (ch) {

			case 1:
				clearScreen();
				add.addStudentDetails();
				break;

			case 2:
				clearScreen();
				add.addTeacherDetails();
				break;

			case 3:
				clearScreen();
				add.addStaffDetails();

			case 4:
				clearScreen();
				displayMainMenu();
				isRunning = false;
				break;

			default:
				System.out.print("\n\t\t\tInvalid choice.");
				pressEnterToContinue();
				clearScreen();
				addRecordSubMenu();
				break;
			}
		}

	}

	// Delete Record Sub Menu
	public void deleteRecordSubMenu() {
		clearScreen();
		System.out.println("\t\t\t****** DELETE RECORD ******\n\n");
		displaySubMenuHeaders();

		int ch = -1;
		System.out.print("\t\t\tEnter your choice : ");
		ch = Integer.parseInt(sc.nextLine());

		switch (ch) {

		case 1:
			clearScreen();
			del.deleteStudentRecordByID();
			break; // break out of case 1 and go back to main menu.

		case 2:
			clearScreen();
			del.deleteTeacherRecordByID();
			break;

		case 3:
			clearScreen();
			del.deleteStaffRecordByID();
			break;
		case 4:
			clearScreen();
			displayMainMenu();
			break;

		default:
			System.out.print("\n\t\t\tInvalid choice.");
			pressEnterToContinue();
			clearScreen();
			deleteRecordSubMenu();
			break;
		}
	}

	// Update Record Sub Menu
	public void updateRecordSubMenu() {
		clearScreen();
		System.out.println("\n\t\t\t****** UPDATE  ITEM ******");
		displaySubMenuHeaders();

		int ch = -1;
		System.out.print("\n\t\t\tEnter your choice : ");
		ch = Integer.parseInt(sc.nextLine());

		switch (ch) {

		case 1:
			update.updateStudentDetails();
			break;

		case 2:
			update.updateTeacherDetails();
			break;

		case 3:
			update.updateStaffDetails();
			break;

		case 4:
			clearScreen();
			displayMainMenu();
			break;

		default:
			System.out.print("\n\t\t\tInvalid choice.");
			pressEnterToContinue();
			clearScreen();
			updateRecordSubMenu();
			break;
		}
	}

	// Search Record Sub Menu
	public void findRecordSubMenu() {
		clearScreen();
		System.out.println("\n\t\t\t****** FIND  ITEM BY ID ******");
		displaySubMenuHeaders();

		int ch = -1;
		System.out.print("\n\t\t\tEnter your choice : ");
		ch = Integer.parseInt(sc.nextLine());

		switch (ch) {

		case 1:
			get.findStudentByID();
			break;

		case 2:
			get.findTeacherByID();
			break;

		case 3:
			get.findStaffByID();
			break;

		case 4:
			clearScreen();
			displayMainMenu();
			break;

		default:
			System.out.print("\n\t\t\tInvalid choice.");
			pressEnterToContinue();
			clearScreen();
			findRecordSubMenu();
			break;
		}
	}

	// Display All Records Sub Menu
	public void displayAllRecordsSubMenu() {

		clearScreen();
		System.out.println("\n\t\t\t****** REPORT  ITEM  ******");
		displaySubMenuHeaders();

		int ch = -1;
		System.out.print("\n\t\t\tEnter your choice : ");
		ch = Integer.parseInt(sc.nextLine());

		switch (ch) {

		case 1:
			clearScreen();
			report.showStudentList();
			continueOrExitProgram();
			break;

		case 2:
			clearScreen();
			report.showTeacherList();
			continueOrExitProgram();
			break;

		case 3:
			clearScreen();
			report.showStaffList();
			continueOrExitProgram();
			break;

		case 4:
			clearScreen();
			displayMainMenu();
			continueOrExitProgram();
			break;

		default:
			System.out.print("\n\t\t\tInvalid choice.");
			pressEnterToContinue();
			clearScreen();
			displayAllRecordsSubMenu();
			break;
		}
	}

	private void displaySubMenuHeaders() {
		System.out.println("\t\t\t1.STUDENT");
		System.out.println("\t\t\t2.TEACHER");
		System.out.println("\t\t\t3.STAFF");
		System.out.println("\t\t\t4.MAIN MENU");
	}

	private void pressEnterToContinue() {
		System.out.print("\n\t\t\tPress Enter key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	private void continueOrExitProgram() {
		char c;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t\tPress C to continue. Press X to exit.");
		System.out.print("       \t\t\t[C]ONTINUE       E[X]IT       ");
		c = sc.next().charAt(0);

		switch (c) {

		case 'c':
		case 'C':
			// displayMainMenu();
			displayAllRecordsSubMenu();
			break;
		case 'x':
		case 'X':
			clearScreen();
			System.out.println("\t\t\tTHANK YOU FOR YOUR TIME. SEE YOU AGAIN!\n\n\n\n\n");
			System.exit(0);
			break;

		}
		sc.close();
	}

	public static void clearScreen() {
		// https://stackoverflow.com/questions/7495916/clear-eclipse-console-java
		System.out.println(new String(new char[70]).replace("\0", "\r\n"));
	}

	public static void clear() {
		for (int i = 0; i < 30; i++) {
			System.out.print('\n');
		}
	}

}
