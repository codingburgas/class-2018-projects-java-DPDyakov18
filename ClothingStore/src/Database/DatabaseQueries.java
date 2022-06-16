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
	public void insertProductListing(String link, int id) throws SQLException {
		try {
			String query = "INSERT INTO ProductListing(ProductListingId, ProductName, Link, Price) "
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, 1);
			stmt.setString(2, ScrapingFromOzone.getProductName());
			stmt.setString(3, link);
			stmt.setString(4, ScrapingFromOzone.getPrice());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCategory(String link) throws SQLException {
		try {
			String query = "INSERT INTO Category(CategoryId, Name) " + "VALUES(?, ?)";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, 1);
			stmt.setString(2, " ");
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
	public void selectProductListing(int id) throws SQLException {
		try {
			String query = "SELECT ProductName, Link, Price FROM ProductListing WHERE ProductListingid = ?";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()) {
				System.out.println("Product name: "+rs.getString("ProductName"));
				System.out.println("Price of product: "+rs.getString("Price"));
				System.out.println("Link to the product: "+rs.getString("Link"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int deleteProductListing(int id) throws SQLException {
		int rowsAffected = 0;
		try {
			String query = "DELETE FROM ProductListing WHERE ProductListingId=?";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, id);
			rowsAffected=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	public int deleteCategory(int id) throws SQLException {
		int rowsAffected = 0;
		try {
			String query = "DELETE FROM Category WHERE CategoryId=?";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, id);
			rowsAffected=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	public int deleteUser(int id) throws SQLException {
		int rowsAffected = 0;
		try {
			String query = "DELETE FROM User WHERE UserId=?";
			PreparedStatement stmt = DatabaseConnection.open().prepareStatement(query);
			stmt.setInt(1, id);
			rowsAffected=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
}