/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 05.11.14
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class TestClass {
    public static void main(String[] args) {
        SendEmail mail = new SendEmail()  ;
        mail.setMessage("Test  massage.");
        mail.sendMessage();
    }
}
