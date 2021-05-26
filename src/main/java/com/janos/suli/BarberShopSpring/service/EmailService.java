package com.janos.suli.BarberShopSpring.service;

import com.janos.suli.BarberShopSpring.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String EMAIL_SENDER;

    private JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Reservation reservation) {
        SimpleMailMessage message = null;

        try {
            message = new SimpleMailMessage();
            message.setFrom(EMAIL_SENDER);
            message.setTo(reservation.getCustomerEmail());
            message.setSubject("Registration complete");
            message.setText("Dear " + reservation.getCustomerFirstName() + " " + reservation.getCustomerLastName() + "!\n\n" +
                            "Thank you for your booking!\n\n" +
                            "Your booking details:\n" +
                            "Name: " + reservation.getCustomerFirstName() + " " + reservation.getCustomerLastName() + "\n" +
                            "Barber: " + reservation.getBookedBarber() + "\n" +
                            "Booked date and time: " + reservation.getBookedDate() + " " + reservation.getBookedTime() + "\n\n" +
                            "This is just a test email, please don't reply!");
            javaMailSender.send(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}
