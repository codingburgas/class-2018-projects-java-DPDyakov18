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
public class Main {

	public static void main(String[] args) throws SQLException {
		String leva="";
    	String stotinki="";
    	String price = "";
		/*System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
		DatabaseConnection connecting = new DatabaseConnection();
		DatabaseConnection.Connecting();
		DatabaseConnection.CloseConnection();
		System.out.println("asas");*/
		   try {
			      // fetch the document over HTTP
			      Document doc = Jsoup.connect("https://www.ozone.bg/product/no-bounds-sport-signature-black/").get();
			      //System.out.println("<span class=\"price\" id=\"product-price-403496\">".length());
			      // get the page title
			      String title = doc.title();
			     // System.out.println("doc: " + doc.toString());
			     // System.out.println("title: " + title);
			      //String price = doc.select("ProductProperties_price_3-lSC itemprop").text();
			      //Element meta = doc.select("[itemprop=price]").first();
			      //String content = meta.attr("content");
			     
			      // get all links in page
			      Elements links = doc.select("div.price-box").select("span.price");

			      
			      	Element link = links.get(1);
			    	  //System.out.println(link.select("span.price").toString());
			    	 price = link.toString().replaceAll("[^0-9]", "");
			    	 if(price.length() > 7) {
			    	 price = price.substring(6);
			    	 stotinki = price.substring(price.length()-2);
			    	 leva = price.substring(0, price.length()-2);
			    	 }else {
			    		 
				    	 stotinki = price.substring(price.length()-2);
				    	 leva = price.substring(0, price.length()-2);
			    	 }
			    	System.out.println(leva +"."+stotinki);
			    	  if(link.select("class").toString().equals("null")) {}
			       //System.out.println("nlink: " + link.attr("_16nzq18"));
			       // System.out.println("text: " + link.text("div.rid-row rendered price-container"));
			      
			    } catch (IOException e) {
			    e.printStackTrace();
	}
}
}