package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.ReservationService;
import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.Reservation;
import pe.edu.upc.faveatfinal.model.repository.CustomerRepository;
import pe.edu.upc.faveatfinal.model.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public JpaRepository<Reservation, Integer> getJpaRepository() {
		return this.reservationRepository;
	}

	@Override
	public List<Reservation> findByCustomer(Integer id) throws Exception {
		if(customerRepository.existsById(id)) {
			Optional<Customer> optional = customerRepository.findById(id);
			return reservationRepository.findByCustomer(optional.get());
		} else {
			return new ArrayList<Reservation>();
		}
		
	}

}