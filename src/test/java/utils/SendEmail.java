package utils;

import java.io.File;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public void senEmail() {
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "chimtu17@gmail.com";
        String password = "hrfrbekvnzztgabz";

        // Outgoing email information
        String mailTo = "milan.amit30@gmail.com";
        String subject = "Test Report";
        String message = "Please find the attached test report.";

        // Attachment file path
        String attachFiles = System.getProperty("user.dir") + "/reports/MadeinChinaReport.html";

        // Check if file exists
        File file = new File(attachFiles);
        if (!file.exists()) {
            System.out.println("File not found: " + attachFiles);
            return;
        }

        try {
            // Display progress bar
            Thread progressBarThread = new Thread(new ProgressBar());
            progressBarThread.start();

            sendEmailWithAttachment(host, port, mailFrom, password, mailTo, subject, message, attachFiles);

            // Stop progress bar
            progressBarThread.interrupt();
            System.out.println("\nEmail Sent Successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }

    public void sendEmailWithAttachment(String host, String port, final String userName, final String password, String toAddress,
                                        String subject, String message, String attachFiles) throws AddressException, MessagingException {
        // Set up server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

        // Create a new email message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new java.util.Date());

        // Create message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");

        // Create a multipart message for attachment
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Second part is attachment
        MimeBodyPart attachPart = new MimeBodyPart();

        try {
            attachPart.attachFile(attachFiles);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        multipart.addBodyPart(attachPart);

        // Set the multipart message to the email message
        msg.setContent(multipart);

        // Send the email
        Transport.send(msg);
    }

    // Inner class to display progress bar
    class ProgressBar implements Runnable {
        @Override
        public void run() {
            int toolbarWidth = 50;
            System.out.print("Sending email: |");
            for (int i = 0; i < toolbarWidth; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.print(":");
                try {
                    Thread.sleep(90); // Adjust the sleep time as needed
                } catch (InterruptedException e) {
                	System.out.print("|");
                    Thread.currentThread().interrupt();
                }
            } 
        }
    }

    public static void main(String[] args) {
        SendEmail sendEmail = new SendEmail();
        sendEmail.senEmail();
    }
}
