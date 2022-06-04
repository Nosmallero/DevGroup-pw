package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.ReservationPaymentService;
import pe.edu.upc.faveatfinal.model.entity.ReservationPayment;
import pe.edu.upc.faveatfinal.model.repository.ReservationPaymentRepository;

@Service
public class ReservationPaymentServiceImpl implements ReservationPaymentService{

	@Autowired
	private ReservationPaymentRepository reservationPaymentRepository;
	
	@Override
	public JpaRepository<ReservationPayment, Integer> getJpaRepository() {
		return this.reservationPaymentRepository;
	}

	@Override
	public List<ReservationPayment> findByIdAndName(Integer id, String nameReservation) throws Exception {
		return this.reservationPaymentRepository.findByIdAndName(id, nameReservation);
	}

}
