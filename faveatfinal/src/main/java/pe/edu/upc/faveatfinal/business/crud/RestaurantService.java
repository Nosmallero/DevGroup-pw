package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.entity.RestaurantOwner;

public interface RestaurantService extends CrudService<Restaurant, Integer> {
	List<Restaurant> findByRestaurantOwner(Integer id) throws Exception;


}
