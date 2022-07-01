package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.MenuRestaurantService;
import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.repository.MenuRestaurantRepository;
import pe.edu.upc.faveatfinal.model.repository.RestaurantRepository;

@Service
public class MenuRestaurantServiceImpl implements MenuRestaurantService{

	@Autowired
	private MenuRestaurantRepository menuRestaurantRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public JpaRepository<MenuRestaurant, Integer> getJpaRepository() {
		return menuRestaurantRepository;
	}

	
	@Override
	public List<MenuRestaurant> findByRestaurant(Integer id) throws Exception {
		if (restaurantRepository.existsById(id)) {
			Optional<Restaurant> optional = restaurantRepository.findById(id);
			return menuRestaurantRepository.findByRestaurant(optional.get());
		} else {
			return new ArrayList<MenuRestaurant>();
		}		
	}

}
