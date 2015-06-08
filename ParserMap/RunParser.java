import jxl.write.WriteException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 15.04.15
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
public class RunParser {
    public static void main(String[] args) throws IOException, WriteException {
        String startLink = "http://maplos.com/streets/kiev";
        ParserMap parser = new ParserMap(startLink) ;
        parser.getStreet();
    }
}
