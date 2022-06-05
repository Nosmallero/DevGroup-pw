package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.DeliveryManService;
import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;
import pe.edu.upc.faveatfinal.model.repository.DeliveryManRepository;

@Service
public class DeliveryManServiceImpl implements DeliveryManService{
	
	@Autowired
	private DeliveryManRepository deliveryManRepository;
	
	@Override
	public JpaRepository<DeliveryMan, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.deliveryManRepository;
	}
	@Override
	public List<DeliveryMan> findByLastName(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return this.deliveryManRepository.findByLastName(lastName);
	}
}
