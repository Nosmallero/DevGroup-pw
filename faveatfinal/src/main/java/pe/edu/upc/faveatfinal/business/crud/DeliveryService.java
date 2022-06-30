package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;


import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;

public interface DeliveryService extends CrudService<Delivery, Integer>{
	List<Delivery> findByCustomer(Integer id) throws Exception;
	List<Delivery> findByRestaurant(Integer id) throws Exception;
}
