package Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.ObjectInputFilter.Config;
import java.io.PrintStream;
import java.sql.Connection;
import Scraping.ScrapingFromOzone;
import static java.nio.charset.StandardCharsets.UTF_8;

public class DatabaseQueries {
	public void insertProductListing(String link) throws SQLException {
		try {
			String query = "INSERT INTO ProductListing(ProductListingId, ProductId, Link, Price) "
					+ "VALUES(?, ?, ?,?)";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, 1);
			stmt.setInt(2, 1);
			stmt.setString(3, link);
			stmt.setString(4, ScrapingFromOzone.getPrice());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCategory(String link) throws SQLException {
		try {
			String query = "INSERT INTO Category(CategoryId, ParentCategoryId, Name) " + "VALUES(?, ?, ?)";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, 1);
			stmt.setInt(2, 1);
			stmt.setString(3, ScrapingFromOzone.getProductName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertProduct(String link) throws SQLException {
		try {
			String query = "INSERT INTO Product(ProductId, CategoryId, Size) " + "VALUES(?, ?, ?)";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, 1);
			stmt.setInt(2, 1);
			stmt.setString(3, "aaaa");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertUser(String link) throws SQLException {
		try {
			String query = "INSERT INTO User(UserId, Username, Address, Email, Password, Role) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, 1);
			stmt.setString(2, " ");
			stmt.setString(3, " ");
			stmt.setString(4, " ");
			stmt.setString(5, " ");
			stmt.setString(6, " ");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}