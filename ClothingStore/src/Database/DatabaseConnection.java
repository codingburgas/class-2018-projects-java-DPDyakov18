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

public class DatabaseConnection {
	private static String url = "jdbc:sqlserver://DESKTOP-SIF0II9\\SQLEXPRESS;databaseName=ClothingStoreDB;encrypt=false;trustServerCertificate=true";
	private static String user = "sa";
	private static String pass = "123";
	static Connection conn;

	public static Connection open() {
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close() throws SQLException {
		conn.close();
	}
}
