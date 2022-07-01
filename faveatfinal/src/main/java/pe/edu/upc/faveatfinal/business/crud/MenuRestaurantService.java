package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;

public interface MenuRestaurantService extends CrudService<MenuRestaurant, Integer>{
	List<MenuRestaurant> findByRestaurant(Integer id) throws Exception;

}
