package com.janos.suli.BarberShopSpring.service;

import com.janos.suli.BarberShopSpring.domain.Reservation;

import java.util.List;

public interface ReservationService {

    public void registerBooking(Reservation reservation);

    public List<Reservation> getAllReservation();

}
