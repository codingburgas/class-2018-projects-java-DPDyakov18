package Main;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import Database.ShowDatabaseData;
public class Main {

	public static void main(String[] args) throws SQLException {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
		DatabaseConnection connecting = new DatabaseConnection();
		ScrapingFromOzone sfo=new ScrapingFromOzone();
		sfo.connectToWebSite();
		sfo.getPrice();		
		DatabaseConnection.open();
		DatabaseConnection.close();
	}
}