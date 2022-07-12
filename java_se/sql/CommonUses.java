package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL and Connector/J is typically used to write DAO classes (MVC
 * architecture), that interact with the Database directly.
 */
public class CommonUses {

	public static void interactWithDatabase() {
		Connector.loadDrivers();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVA_SE", "root", "password");
				Statement stmt = conn.createStatement()) {

			System.out.println("Connection established... \n");
			readData(stmt);
			writeData(stmt);
			readData(stmt);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void readData(Statement stmt) throws SQLException {

		String query = "SELECT * FROM Book";

		ResultSet rs = stmt.executeQuery(query);
		// ExecuteQuery is used to execute SELECT queries.
		// Returns a ResultSet of data requested.

		while (rs.next()) { // A while loop is used to access all rows.
			/*
			 * rs.next() returns boolean, and advances the rs to the next row. SQL stores
			 * data beginning at row 1, and thus, next() must be called prior to accessing
			 * the first and all subsequent rows.
			 */

			// Retrieving data from each row.
			String title = rs.getString("title"); // args = column names.
			Long year_published = rs.getLong("year_published");

			System.out.println(title + ", " + year_published);

			/*
			 * Typically, a SQL table mirrors a Java class. Though, due to normalization, it
			 * might not be a 1:1 relation. Ex: A book has multiple authors.
			 */
		}

	}

	public static void writeData(Statement stmt) throws SQLException {

		String script = "INSERT INTO Book (title, year_published, reading_status) VALUES "
				+ "(\"Sapiens\", 1993, \"Finished\");";

		int rowsAffected = stmt.executeUpdate(script);
		// ExecuteUpdate is used to execute INSERT, UPDATE, DELETE or DDL statements.
		// Returns number of rows affected.

		System.out.println("\nRows affected: " + rowsAffected + "\n");
	}

	public static void main(String[] args) {
		interactWithDatabase();
	}

}
