package pe.edu.upc.faveatfinal.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.CreditCard;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{

}
