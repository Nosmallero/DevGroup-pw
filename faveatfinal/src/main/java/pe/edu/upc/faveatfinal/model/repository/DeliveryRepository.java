package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Delivery;


@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
	List<Delivery> findByCustomer(Customer customer) throws Exception;
}
