package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Requires the MySQL Connector/J reference library to be added to the build
 * path.
 */
public class Connector {

	public static void loadDrivers() {
		try {

			// Used to load the MySQL drivers, and enabling interaction.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Alternate ways:
			// System.setProperty("jdbc.drivers", "com.mysql.cj.jdbc.Driver");
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		} catch (ClassNotFoundException e) {
			System.out.println("Drivers could not be laoded properly.");
			e.printStackTrace();
		}
	}

	public static void establishConnection() {

		loadDrivers();

		String dbPath = "jdbc:mysql://localhost:3306/JAVA_SE";
		// <protocol>:<sub-protocol>:<path>
		String username = "root";
		String password = "password";

		try (Connection conn = DriverManager.getConnection(dbPath, username, password);
				Statement stmt = conn.createStatement()) {
			// Connection is used to connect to the database.
			// Statement is used to execute any SQL queries.

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public static void main(String[] args) {
		establishConnection();
	}
}
