package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.FoodsOrderService;
import pe.edu.upc.faveatfinal.model.entity.FoodsOrder;
import pe.edu.upc.faveatfinal.model.repository.FoodsOrderRepository;

@Service
public class FoodsOrderImpl implements FoodsOrderService {

	@Autowired
	private FoodsOrderRepository foodsOrderRepository;
	
	@Override
	public JpaRepository<FoodsOrder, Integer> getJpaRepository() {
		return this.foodsOrderRepository;
	}

}
