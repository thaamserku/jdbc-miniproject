package ui;

public class UserValidation {

	private String username;
	private String password;
	private String[][] accounts = { { "kshitiz", "ksh123" }, { "ramesh", "ram567" } };

	public UserValidation(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean checkPassword() {

		if ((username.equals(accounts[0][0])) && (password.equals(accounts[0][1])))
			return true;
		else
			return false;
	}

}
