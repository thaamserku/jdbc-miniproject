package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*-
 * This class is all about using JDBC to establish connection 
 * to MySQL database.
 */
public class ConnectionSetting {

	/*-
	 * Declare relevant constants;
	 */
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "Kathmandu@1410";

	/*-
	 *  1. The following constructor loads the JDBC driver for MySQL.
	 *  2. No need to explicitly load driver since JDBC 4.0 and java 1.6 though.
	 *  	When the Connection is returned with getConnection, the driver is implicitly loaded first.
	 *  3. Keep it as a demo as to how to do it via constructor.
	 */
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
