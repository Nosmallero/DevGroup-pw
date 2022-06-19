package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.FoodService;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public JpaRepository<Food, Integer> getJpaRepository() {
		return foodRepository;
	}

	@Override
	public List<Food> findByName(String name) throws Exception {
		return this.foodRepository.findByName(name);
		}

}
