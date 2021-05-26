package com.janos.suli.BarberShopSpring.repository;

import com.janos.suli.BarberShopSpring.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAll();

}
