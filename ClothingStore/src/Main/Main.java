package Main;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import Scraping.ScrapingFromOzone;
import Database.DatabaseConnection;
import Database.DatabaseQueries;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
		String link = sc.nextLine();
		ScrapingFromOzone sfo = new ScrapingFromOzone();
		DatabaseConnection dbc = new DatabaseConnection();
		DatabaseQueries dbq = new DatabaseQueries();
		Document doc;
		dbc.open();
		sfo.connectToWebSite(link);
		dbq.insertProductListing(link);
		DatabaseConnection.close();
	}
}