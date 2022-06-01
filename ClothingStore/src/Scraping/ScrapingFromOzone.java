package Scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingFromOzone {
	String leva = "";
	String stotinki = "";
	String price = "";
	Document doc;

	public void connectToWebSite() {
		try {
			doc = Jsoup.connect("https://www.ozone.bg/product/sony-playstation-5/").get();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getPrice() {
		connectToWebSite();
		// System.out.println("<span class=\"price\"
		// id=\"product-price-403496\">".length());
		// System.out.println("doc: " + doc.toString());
		System.out.println("title: " + doc.title());

		Elements links = doc.select("div.price-box").select("span.price");

		Element link = links.get(1);
		// System.out.println(link.select("span.price").toString());
		price = link.toString().replaceAll("[^0-9]", "");
		if (price.length() > 7) {
			price = price.substring(6);
			stotinki = price.substring(price.length() - 2);
			leva = price.substring(0, price.length() - 2);
		} else {

			stotinki = price.substring(price.length() - 2);
			leva = price.substring(0, price.length() - 2);
		}
		System.out.println(leva + "." + stotinki);
		if (link.select("class").toString().equals("null")) {
		}
	}
}
