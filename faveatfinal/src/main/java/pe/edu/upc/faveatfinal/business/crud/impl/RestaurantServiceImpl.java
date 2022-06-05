package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.repository.RestaurantRepository;



@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public JpaRepository<Restaurant, Integer> getJpaRepository() {
		return this.restaurantRepository;
	}

}
