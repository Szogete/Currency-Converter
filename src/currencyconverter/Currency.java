package currencyconverter;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Currency {
   
    public static double getCurrency(String waluta) throws IOException
	{
		org.jsoup.nodes.Document dc = Jsoup.connect("http://kursy-walut.mybank.pl/").timeout(6000).get();
		Elements body = dc.select("div.cen");
		
		for (Element kat : body)
		{
			Elements eur = kat.getElementsByAttributeValue("title", "Kurs średni " +waluta);
			if(eur.size() > 0)
			{
				return	Double.parseDouble(eur.text().replace(',', '.'));
			}
			
		}
		return -1;
	}
}
