package app;

import ui.Menu;

public class Main {

	public static void main(String[] args) {

		Menu m = new Menu();

		/*-
		 * 1. Loads Menu class and creates an instance of it 
		 * 2. Validates user 
		 * 3. If
		 * user is validated, displays main menu
		 * 
		 */

		m.logInHeader();
		m.validateUser();
		System.out.println();
		m.displayMainMenu();

	}
}
