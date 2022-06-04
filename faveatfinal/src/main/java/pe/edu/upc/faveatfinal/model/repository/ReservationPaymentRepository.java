package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.faveatfinal.model.entity.ReservationPayment;

@Repository
public interface ReservationPaymentRepository extends JpaRepository<ReservationPayment, Integer>{
	List<ReservationPayment> findByIdAndName(Integer id, String nameReservation) throws Exception;
	
}
