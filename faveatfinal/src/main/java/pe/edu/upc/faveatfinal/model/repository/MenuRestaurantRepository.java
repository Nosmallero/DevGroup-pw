package pe.edu.upc.faveatfinal.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;

@Repository
public interface MenuRestaurantRepository extends JpaRepository<MenuRestaurant, Integer>{

}
