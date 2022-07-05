package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSetting {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "Kathmandu@1410";

	// this constructor loads the driver
	// no need to load driver since JDBC 4.0 and java 1.6 though.
	// Just to demo how it can be done via constructor
	public ConnectionSetting() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			System.out.println("MySQL Driver not found..");
		}

	}// End of ConnectionSettin()

	public Connection getConnection() {

		try {
			return DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Could not establish conneciton with database.");
			e.printStackTrace();
		}
		return null;

	}// End of getConnection()

}
