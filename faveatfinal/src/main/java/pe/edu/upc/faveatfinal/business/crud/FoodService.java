package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;

public interface FoodService extends CrudService<Food, Integer>{
	List<Food> findByMenuRestaurant(Integer id) throws Exception;
	List<Food> findByName(String name) throws Exception;

}
