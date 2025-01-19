package com.janos.suli.BarberShopSpring.controller;

import com.janos.suli.BarberShopSpring.domain.Reservation;
import com.janos.suli.BarberShopSpring.service.EmailService;
import com.janos.suli.BarberShopSpring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private ReservationService reservationService;
    private EmailService emailService;

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservation());
        return "admin";
    }

    @GetMapping("/")
    public String index(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "index";
    }

    @PostMapping("/booking")
    public String booking(@ModelAttribute Reservation reservation) {
        reservationService.registerBooking(reservation);
        emailService.sendEmail(reservation);
        return "success";
    }

    //new test line

}
