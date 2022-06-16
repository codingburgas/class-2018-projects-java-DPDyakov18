package Scraping;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingFromOzone {
	Scanner sc = new Scanner(System.in);
	public static String leva = "";
	public static String stotinki = "";
	public static String price = "";
	static Document doc;
	public static String link;
	String[] linkList;

	public void connectToWebSite(String link) {
		try {
			this.link = link;
			Jsoup.connect(link).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getPrice() {
		try {
			doc = Jsoup.connect(link).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements links = doc.select("div.price-box").select("span.price");

		Element link = links.get(1);
		price = link.toString().replaceAll("[^0-9]", "");
		if (price.length() > 7) {
			price = price.substring(6);
			stotinki = price.substring(price.length() - 2);
			leva = price.substring(0, price.length() - 2);
		} else {

			stotinki = price.substring(price.length() - 2);
			leva = price.substring(0, price.length() - 2);
		}
		if (link.select("class").toString().equals("null")) {
		}
		price = leva + "." + stotinki;
		return price;
	}

	public static String getProductName() {
		String[] title = doc.title().toString().split("Ozone.bg");
		return title[0];
	}
}