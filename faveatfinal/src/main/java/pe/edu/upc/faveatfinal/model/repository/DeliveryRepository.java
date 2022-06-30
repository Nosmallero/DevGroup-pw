package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;



@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
	List<Delivery> findByCustomer(Customer customer) throws Exception;
	List<Delivery> findByRestaurant(Restaurant restaurant) throws Exception;
}
