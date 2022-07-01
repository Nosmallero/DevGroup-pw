package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{
	List<Food> findByMenuRestaurant(MenuRestaurant menuRestaurant) throws Exception;
	List<Food> findByName(String name) throws Exception;

}