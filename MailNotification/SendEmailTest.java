/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 01.12.14
 * Time: 18:30
 * To change this template use File | Settings | File Templates.
 */
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailTest {
    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "testmail@cloudera.esy.es";

        // Sender's email ID needs to be mentioned
        String from = "testmail@cloudera.esy.es";
        final String username = "testmail@cloudera.esy.es";//change accordingly
        final String password = "*****";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "mx1.hostinger.com.ua";
        String port = "2525";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Mail");

            // Now set the actual message
            message.setText("Hello, this is sample for to check send email using JavaMailAPI ");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}