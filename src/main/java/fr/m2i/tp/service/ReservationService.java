package fr.m2i.tp.service;

import java.util.List;

import fr.m2i.tp.entity.Payement;
import fr.m2i.tp.entity.Reservation;

public interface ReservationService {

	public Reservation makeReservation(Long customerId, Long sessionId, List<Long> participantIds);

	public void attachPayment(Long reservationId, Payement payment);

	public Reservation findReservationById(Long reservationId);

	public List<Reservation> findReservationsByCriteria(Long customerId, Long spectacleId);

	public void cancelReservation(Long reservationId);
}
