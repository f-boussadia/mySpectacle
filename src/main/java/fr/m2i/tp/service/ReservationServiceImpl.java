package fr.m2i.tp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.tp.dao.DaoReservation;
import fr.m2i.tp.entity.Payement;
import fr.m2i.tp.entity.Reservation;

@Service // hérite de @Coponent
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private DaoReservation daoReservation;

	public ReservationServiceImpl() {
		System.out.println("dans constructeur daoReservation = " + daoReservation);
	}

	@PostConstruct
	public void init() {
		System.out.println("dans la fonction init préfixé par PostConstruct daoReservation = " + daoReservation);
	}

	@Override
	public Reservation makeReservation(Long customerId, Long sessionId, List<Long> participantIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attachPayment(Long reservationId, Payement payment) {
		// TODO Auto-generated method stub

	}

	@Override
	public Reservation findReservationById(Long reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findReservationsByCriteria(Long customerId, Long spectacleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelReservation(Long reservationId) {
		// TODO Auto-generated method stub

	}

}
