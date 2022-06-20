package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.faveatfinal.model.entity.DeliveryPayment;

@Repository
public interface DeliveryPaymentRepository extends JpaRepository<DeliveryPayment, Integer>{
	List<DeliveryPayment> findByIdAndNameDelivery(Integer id, String nameDelivery) throws Exception;
	
}
