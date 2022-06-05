package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Integer>{
	List<DeliveryMan> findByLastName(String lastName) throws Exception;
}
