package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.entity.RestaurantOwner;
import pe.edu.upc.faveatfinal.model.repository.DeliveryRepository;
import pe.edu.upc.faveatfinal.model.repository.RestaurantOwnerRepository;
import pe.edu.upc.faveatfinal.model.repository.RestaurantRepository;



@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RestaurantOwnerRepository restaurantOwnerRepository;
	

	
	
	@Override
	public JpaRepository<Restaurant, Integer> getJpaRepository() {
		return this.restaurantRepository;
	}


	@Override
	public List<Restaurant> findByRestaurantOwner(Integer id) throws Exception {
		if (restaurantOwnerRepository.existsById(id)) {
			Optional<RestaurantOwner> optional = restaurantOwnerRepository.findById(id);
			return restaurantRepository.findByRestaurantOwner(optional.get());
		} else {
			return new ArrayList<Restaurant>();
		}		
	}


	

}
