package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.OrderService;
import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Order;
import pe.edu.upc.faveatfinal.model.repository.CustomerRepository;
import pe.edu.upc.faveatfinal.model.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public JpaRepository<Order, Integer> getJpaRepository() {
		return this.orderRepository;
	}

	@Override
	public List<Order> findByCustomer(Integer id) throws Exception {
		if(customerRepository.existsById(id)) {
			Optional<Customer> optional = customerRepository.findById(id);
			return orderRepository.findByCustomer(optional.get());
		} else {
			return new ArrayList<Order>();
		}
	}
	

}
