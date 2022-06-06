package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.OrderService;
import pe.edu.upc.faveatfinal.model.entity.Order;
import pe.edu.upc.faveatfinal.model.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public JpaRepository<Order, Integer> getJpaRepository() {
		return this.orderRepository;
	}

}
