package webscrappers;

import DbHelper.Article;

public class Techworm {

	private static final String URL_PATH = "http://www.techworm.net/";
	private Article article;
	private 
	
	public static String activateScrapper()
	{
		
		Document doc = Jsoup.connect(URL_PATH).get();
		
		return null;
		
	}
}
