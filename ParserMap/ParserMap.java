import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 15.04.15
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
public class ParserMap {
    private String mainLink;
    private final String baseLink = "http://maplos.com";

    public ParserMap (String mainLink ) throws IOException {
        this.mainLink = mainLink;
    }

    public void getStreet() throws IOException {
       Document doc = Jsoup.connect(mainLink).get();

       //Получаем ссылку улици
       Elements streetLists = doc.select("a[href]");

        for (Element element : streetLists ) {
            String street = element.text();
            String streetLink = element.attr("href");
            getBuild(street, baseLink + streetLink) ;
            }
        }


    //получить номера домово
    public  void getBuild(String street,String link) throws IOException {
        Document doc = Jsoup.connect(link).get();

        Element body = doc.select("div.b-content").first() ;
        String stringBody = body.toString() ;

        int start = stringBody.indexOf("houses");
        int end = stringBody.indexOf("b-content__full-screen");
        String buildings = stringBody.substring( start + 1,end);
        Boolean skanEnd = true;
        int index = buildings.indexOf("house");

        while (skanEnd) {
           if (index > -1) {
               buildings = buildings.substring(index + 8);
               int sumbol = buildings.indexOf("'");
               String numberBuild = buildings.substring(0, sumbol);
               System.out.println(street + "$" + numberBuild);
               index =  buildings.indexOf("house");
           }
           else  skanEnd = false;
        }
    }
}
