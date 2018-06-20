package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;



/**
 * Created by ionixx on 5/11/18.
 */
public class Utility {

    public static void sendTestReportMail() {
        try {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentTime = dateFormat.format(date);

            final String fromEmail = "testautomation.result1@gmail.com"; // requires

            final String password = "automationnewresult"; // correct password for

            final String toEmail = "thangaraj.matheson@ionixxtech.com";


            File input = new File(System.getProperty("user.dir")+ File.separator+"target" +
                    File.separator+"output"+File.separator+"report.html");
            Document doc = Jsoup.parse(input, "UTF-8",
                    System.getProperty("user.dir")+ File.separator+"target" +
                            File.separator+"output"+File.separator+"report.html");

            // Elements span = doc.select("span.strong.tooltipped");
            String span = doc.select("span.strong").toString();
            span = span.toString().replaceAll("\\<.*\\\"\\>", "").replaceAll("\\<.*\\>", "").replaceAll("\n", "");
            char[] numberArray = span.toCharArray();
            int totalScenarioPassCount = Integer.parseInt(Character.toString(numberArray[3]));
            int totalScenarioFailCount = Integer.parseInt(Character.toString(numberArray[4]));
            int totalStepsPassCount = Integer.parseInt(Character.toString(numberArray[6]));
            int totalStepsFailCount = Integer.parseInt(Character.toString(numberArray[7]));


            System.out.println("Sending Email Started ............");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
            props.put("mail.smtp.port", "587"); // TLS Port
            props.put("mail.smtp.auth", "true"); // enable authentication
            props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

            // create Authenticator object to pass in Session.getInstance
            // argument
            Authenticator auth = new Authenticator() {
                // override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);
            // set message headers
            msg.addHeader("Content-type", "text/html; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@journaldev.com", "Automation Result"));

            msg.setReplyTo(InternetAddress.parse("testautomation.result1@gmail.com", false));

            msg.setSubject("Automation Execution Result - " + currentTime, "UTF-8");

            String body = "<html><body> <h4>Automation execution result short summary listed below:</h4>"

                    + "<h4 style=\"color:#0d2f5d;\"><i> Scenarios</i></h4>"
                    + "<table border='0' style='border-collapse:collapse' width=\"28%\"><tbody>"
                    + "<tr><td style='border:1px solid rgb(0,0,0)' width=\"80%\"> <i>Total Scenarios Count </i> </td>"
                    + "<td width='20%' style='border:1px solid rgb(0,0,0);font-weight:bold;text-align:center'>"
                    + (totalScenarioPassCount + totalScenarioFailCount) + "</td></tr>"
                    + "<tr><td style='border:1px solid rgb(0,0,0)' width=\"80%\"><i>Total Passed Scenarios Count  </i> </td>"
                    + "<td width='20%' style='border:1px solid rgb(0,0,0);font-weight:bold;text-align:center'>"
                    + totalScenarioPassCount + " </td></tr>"
                    + "<tr><td style='border:1px solid rgb(0,0,0)' width=\"80%\"><i>Total Failed Scenarios Count </i> </td>"
                    + "<td width='20%' style='border:1px solid rgb(0,0,0);font-weight:bold;text-align:center;background-color:rgb(255,0,0)'>"
                    + totalScenarioFailCount + "</td></tr> </tbody></table> &nbsp;&nbsp;&nbsp;&nbsp;"

                    + "<h4 style=\"color:#0d2f5d;\"><i> Steps</i></h4>"
                    + "<table border='0' style='border-collapse:collapse' width=\"28%\"><tbody>"
                    + "<tr><td style='border:1px solid rgb(0,0,0)' width=\"80%\"> <i>Total Steps Count </i> </td>"
                    + "<td width='20%' style='border:1px solid rgb(0,0,0);font-weight:bold;text-align:center'>"
                    + (totalStepsPassCount + totalStepsFailCount) + "</td></tr>"
                    + "<tr><td style='border:1px solid rgb(0,0,0)' width=\"80%\"><i>Total Passed Steps Count  </i> </td>"
                    + "<td width='20%' style='border:1px solid rgb(0,0,0);font-weight:bold;text-align:center'>"
                    + totalStepsPassCount + " </td></tr>"
                    + "<tr><td style='border:1px solid rgb(0,0,0)' width=\"80%\"><i>Total Failed Steps Count </i> </td>"
                    + "<td width='20%' style='border:1px solid rgb(0,0,0);font-weight:bold;text-align:center;background-color:rgb(255,0,0)'>"
                    + totalStepsFailCount + " </td></tr> </tbody></table> &nbsp;&nbsp;&nbsp;&nbsp;"

                    + "<h4>Download attached html file and double click on it to view the test report in detail.</h4>"

                    + "Thanks <br><i>Ionixx Technologies</i> </body></html>";

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());
            msg.setContent(body, "text/HTML");

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(body);

            messageBodyPart.setHeader("Content-type", "text/html; charset=UTF-8");
            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            File directory = new File(System.getProperty("user.dir")+ File.separator+"target" +
                    File.separator+"output");
            File[] fileList = directory.listFiles();

            for (int fileCount = 0; fileCount < fileList.length; fileCount++) {

                int attachmentCount =1;

                if(fileList[fileCount].getName().equalsIgnoreCase("report.html")) {

                    // Second part is attachment
                    messageBodyPart = new MimeBodyPart();

                    String filename = fileList[fileCount].getName();

                    DataSource source = new FileDataSource(directory + File.separator + filename);
                    messageBodyPart.setDataHandler(new DataHandler(source));

                    messageBodyPart.setFileName(filename);
                    multipart.addBodyPart(messageBodyPart, attachmentCount);
                    attachmentCount++;
                }
            }

            // Send the complete message parts
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);
            System.out.println("EMail Sent Successfully ............");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
