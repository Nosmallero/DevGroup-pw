package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.MenuRestaurantService;
import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;
import pe.edu.upc.faveatfinal.model.repository.MenuRestaurantRepository;

@Service
public class MenuRestaurantServiceImpl implements MenuRestaurantService{

	@Autowired
	private MenuRestaurantRepository menuRestaurantRepository;
	
	@Override
	public JpaRepository<MenuRestaurant, Integer> getJpaRepository() {
		return menuRestaurantRepository;
	}

}
