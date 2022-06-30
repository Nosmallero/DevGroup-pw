package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.entity.RestaurantOwner;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant ,Integer>{
	List<Restaurant> findByRestaurantOwner(RestaurantOwner restaurantOwner) throws Exception;
}
