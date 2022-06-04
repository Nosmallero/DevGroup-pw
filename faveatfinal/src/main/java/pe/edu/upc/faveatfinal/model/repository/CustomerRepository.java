package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByLastName(String lastName) throws Exception;
}
