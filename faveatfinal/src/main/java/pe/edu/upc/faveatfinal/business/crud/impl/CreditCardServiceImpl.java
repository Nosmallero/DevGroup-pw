package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.CreditCardService;
import pe.edu.upc.faveatfinal.model.entity.CreditCard;
import pe.edu.upc.faveatfinal.model.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Override
	public JpaRepository<CreditCard, Integer> getJpaRepository() {
		return this.creditCardRepository;
	}

}
