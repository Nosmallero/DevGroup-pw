package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;

@Repository
public interface MenuRestaurantRepository extends JpaRepository<MenuRestaurant, Integer>{
	List<MenuRestaurant> findByRestaurant(Restaurant Restaurant) throws Exception;

}
