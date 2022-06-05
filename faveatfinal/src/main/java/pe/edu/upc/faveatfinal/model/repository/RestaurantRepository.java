package pe.edu.upc.faveatfinal.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.faveatfinal.model.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant ,Integer>{
}
