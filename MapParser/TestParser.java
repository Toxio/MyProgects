import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 18.02.15
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public class TestParser {
    public static void main(String[] args) throws IOException {
    String mainLink = "http://hotline.ua/remont/bojlery-kolonki-vodonagrevateli/1027/";
    int listNumbers = 1;
    Parser parser = new Parser(mainLink,listNumbers) ;
        parser.getLinks();
    }
}
