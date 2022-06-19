package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{
	List<Food> findByName(String name) throws Exception;

}