package Main;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class DatabaseConnection {
	private static String url="jdbc:sqlserver://DESKTOP-SIF0II9\\SQLEXPRESS;databaseName=ClothingStoreDB;encrypt=false;trustServerCertificate=true";
	private static String user="sa";
	private static String pass="123";
	private static Connection conn;
	
	
	public static void  Connecting() throws SQLException {
		System.out.println("Connecting...");
		conn=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected!");
	}

	public static void CloseConnection() throws SQLException {
		conn.close();
	}
	public void ShowCustomers() throws SQLException {
		String query1 = "INSERT INTO Product VALUES ('test','1','test')";
		Statement stmt = conn.createStatement();
		
		
		ResultSet rs = stmt.executeQuery(query1);
		
		while (rs.next()) {
			System.out.println(rs.getString("first_name"));
		}
	}
}
