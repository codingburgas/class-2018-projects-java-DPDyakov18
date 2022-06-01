package Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import Scraping.ScrapingFromOzone;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ShowDatabaseData {

	public void ShowCustomers() throws SQLException {
		try {
			DatabaseConnection dbc = new DatabaseConnection();
			String query1 = "INSERT INTO Product VALUES ('test','1','test')";
			Statement stmt = dbc.conn.createStatement();
			ResultSet rs = stmt.executeQuery(query1);

			while (rs.next()) {
				System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}