package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.PaymentTypeService;
import pe.edu.upc.faveatfinal.model.entity.PaymentType;
import pe.edu.upc.faveatfinal.model.repository.PaymentTypeRepository;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;
	
	@Override
	public JpaRepository<PaymentType, Integer> getJpaRepository() {
		return this.paymentTypeRepository;
	}

}
