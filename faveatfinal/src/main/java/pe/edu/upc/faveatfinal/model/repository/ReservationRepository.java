package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	List<Reservation> findByCustomer(Customer customer) throws Exception;
}
