package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.DeliveryService;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Override
	public JpaRepository<Delivery, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.deliveryRepository;
	}

}
