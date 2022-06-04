package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.RestaurantOwner;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner, Integer>{
	List<RestaurantOwner> findByFirstName(String firstName) throws Exception;
}
