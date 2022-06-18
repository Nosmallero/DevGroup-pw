package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.ReservationService;
import pe.edu.upc.faveatfinal.model.entity.Reservation;
import pe.edu.upc.faveatfinal.model.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public JpaRepository<Reservation, Integer> getJpaRepository() {
		return this.reservationRepository;
	}

}