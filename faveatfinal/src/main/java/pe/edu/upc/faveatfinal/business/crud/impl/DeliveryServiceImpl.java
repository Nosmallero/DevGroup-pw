package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.DeliveryService;
import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.repository.CustomerRepository;
import pe.edu.upc.faveatfinal.model.repository.DeliveryRepository;
import pe.edu.upc.faveatfinal.model.repository.RestaurantRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public JpaRepository<Delivery, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.deliveryRepository;
	}

	@Override
	public List<Delivery> findByCustomer(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if(customerRepository.existsById(id)) {
			Optional<Customer> optional = customerRepository.findById(id);
			return deliveryRepository.findByCustomer(optional.get());
		} else {
			return new ArrayList<Delivery>();
		}
		
	}

	@Override
	public List<Delivery> findByRestaurant(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if(restaurantRepository.existsById(id)) {
			Optional<Restaurant> optional = restaurantRepository.findById(id);
			return deliveryRepository.findByRestaurant(optional.get());
		} else {
			return new ArrayList<Delivery>();
		}
		
	}

}
