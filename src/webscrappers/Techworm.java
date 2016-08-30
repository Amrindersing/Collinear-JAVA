package webscrappers;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DbHelper.Article;

public class Techworm {

	private static final String URL_PATH = "http://www.techworm.net/";

	private static String data;
	private static Document webpage;
	private static Elements articles;
	
	
	public static ArrayList<Article> activateScrapper() throws IOException
	{
		
		webpage = Jsoup.connect(URL_PATH).get();
		
		articles = webpage.getElementsByTag("article");
		
		
		ArrayList<Article> ar = new ArrayList<>();
		Elements temp;
		
		
		for (Element data : articles) {

			temp = data.getElementsByClass("excerpt");
			String title = temp.text();
			System.out.println(title);
			
			temp = data.select("a > img");
			System.out.println(temp.attr("src"));
			String image = temp.attr("src");
			
			String link = null;
			
			Article article = new Article(title, image, link);
			ar.add(article);
			
			break;
		}
		
		return ar;
		
	}
	
	public static void main(String[] args) {
		
		try {
			Techworm.activateScrapper();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
