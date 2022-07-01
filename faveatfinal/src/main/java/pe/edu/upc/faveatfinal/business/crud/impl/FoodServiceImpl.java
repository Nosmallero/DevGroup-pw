package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.FoodService;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.repository.FoodRepository;
import pe.edu.upc.faveatfinal.model.repository.MenuRestaurantRepository;
import pe.edu.upc.faveatfinal.model.repository.RestaurantRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private MenuRestaurantRepository menuRestaurantRepository;
	

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public JpaRepository<Food, Integer> getJpaRepository() {
		return foodRepository;
	}

	@Override
	public List<Food> findByName(String name) throws Exception {
		return this.foodRepository.findByName(name);
	}

	@Override
	public List<Food> findByMenuRestaurant(Integer id) throws Exception {
		if (menuRestaurantRepository.existsById(id)) {
			Optional<MenuRestaurant> optional = menuRestaurantRepository.findById(id);
			return foodRepository.findByMenuRestaurant(optional.get());

		} else {
			return new ArrayList<Food>();
		}
	}
}
