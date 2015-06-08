/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 12.02.15
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private String mainLink;
    private int listNumbers;

    public Parser(String mainLink,int listNumbers ) throws IOException {
        this.mainLink = mainLink;
        this.listNumbers = listNumbers;
    }

    public void getLinks() throws IOException {
        Document docMain = Jsoup.connect(mainLink).get();

        //определяем количество страниц
        Elements numberLists = docMain.select("div.pager");
        String numberList = numberLists.attr("span");

        for (int i = 0; i < listNumbers; i++) {
         //Получаем ссылки на товар
          Document doc ;
          if (i == 0 ) {
             doc = docMain;
          }else {
             doc = Jsoup.connect(mainLink + "?p=" + i).get();
          }
          Elements metaElements = doc.select("div.title-box");

        /*  for (Element element : metaElements ) {
              Elements allLinks = element. select("a[href]");
              String name = allLinks.text();
              String link = allLinks.attr("href");
              int n = link.indexOf("?tab") ;
              if (n > 0) link = link.substring( 0, n);
              link = "http://hotline.ua" + link;

              System.out.println("Товар: " + name);
              System.out.println("Ссылка: " + link);
               getPicture(link);
          }    */

            Document docArticle = Jsoup.connect("http://hotline.ua/remont-bojlery-kolonki-vodonagrevateli/electrolux-gwh-265-ern-nano-plus/").get();

            //короткий список хар-к поиск по id
           /* Elements shortList = docArticle.select("#short-props-list");
            getInfo(shortList);
            System.out.println("----------------------------------");  */

            //Полный список хар-к  поиск по id
            Elements fullList = docArticle.select("#full-props-list");
            getInfo(fullList);
       }

    }

    //получить ссылки на фото
    public  void getPicture(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();

        // Elements pic = doc.select("div.g-img-box");
        Elements pic = doc.select("div.inner-g");
        Elements allLinks = pic. select("a[href]");
        for (Element element : allLinks ) {
            String linkPic = element.attr("href");
            linkPic = "http://hotline.ua" + linkPic;
            System.out.println(linkPic);
        }
    }

    //Получить характеристику товара
    public  void getInfo(Elements deskription) throws IOException {

        Elements features = deskription.select("th");
        Elements descriptions = deskription.select("td");
        Elements titles = deskription.select("th.title");

        ArrayList<String> listFeature = new ArrayList<String>() ;
        ArrayList<String> listDescription = new ArrayList<String>() ;

        /*for (int i = 0; i < features.size() - 1; i++ ) {
            listFeature.add(features.get(i).text());
            listDescription.add(descriptions.get(i).text());
        }
        //Удалим 2-й елемент картинку в хар-ках
        for (int i = 0; i <listFeature.size() ; i++) {
            System.out.println(listFeature.get(i));
        }   */
        for (int i = 0; i <features.size() ; i++) {
            String feature  = features.get(i).text();
          //  String deskript = descriptions.get(i).text();
          //  String title = titles.get(i).text();
            String b = features.attr("title") ;
           // if (  features.attr("") == "")
                System.out.println(feature + "----");
            //  System.out.println("******" + title);

        }
    }




}
