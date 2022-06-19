package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.Food;

public interface FoodService extends CrudService<Food, Integer>{
	List<Food> findByName(String name) throws Exception;

}
