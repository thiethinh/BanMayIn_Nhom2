package com.papercraft.utils;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtils {

    // Tạo mã OTP ngẫu nhiên
    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public static void sendEmail(String toEmail, String otpCode) {
        // Cấu hình gửi mail (Dùng Gmail làm server)
        final String fromEmail = "papercraftmain@gmail.com";
        final String password = "tbgj xkow uatn qtfv";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
        props.put("mail.smtp.port", "587"); // // Cổng kết nối (587 dùng cho giao thức TLS)
        props.put("mail.smtp.auth", "true"); // Bắt buộc phải đăng nhập
        props.put("mail.smtp.starttls.enable", "true"); // Bật mã hóa TLS để bảo mật

        // Tạo Authenticator xác thực
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage msg = new MimeMessage(session);

            // Header
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(fromEmail, "PaperCraft Support"));
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            msg.setSubject("Mã xác thực Quên Mật Khẩu", "UTF-8");
            msg.setSentDate(new java.util.Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            // Nội dung Email
            String body = "<h3>Xin chào,</h3>"
                    + "<p>Bạn đã yêu cầu đặt lại mật khẩu tại PaperCraft.</p>"
                    + "<p>Mã OTP của bạn là: <strong style='color:red; font-size: 16px;'>" + otpCode + "</strong></p>"
                    + "<p>Mã này sẽ hết hạn trong 5 phút.</p>";

            msg.setContent(body, "text/html; charset=UTF-8");

            // Gửi mail
            Transport.send(msg);
            System.out.println("Gửi email thành công đến: " + toEmail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}