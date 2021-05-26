package com.janos.suli.BarberShopSpring.service;

import com.janos.suli.BarberShopSpring.domain.Reservation;
import com.janos.suli.BarberShopSpring.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImplementation implements ReservationService{

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImplementation(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void registerBooking(Reservation reservation) {
      reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }
}
