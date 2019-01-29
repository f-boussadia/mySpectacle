package fr.m2i.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.m2i.tp.entity.Reservation;

public interface DaoReservation extends CrudRepository<Reservation, Long> {

}
