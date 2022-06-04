package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.RestaurantOwnerService;

import pe.edu.upc.faveatfinal.model.entity.RestaurantOwner;
import pe.edu.upc.faveatfinal.model.repository.RestaurantOwnerRepository;





@Service
public class RestaurantOwnerServiceImpl implements RestaurantOwnerService{
	
	@Autowired
	private RestaurantOwnerRepository restaurantOwnerRepository;
	@Override
	public JpaRepository<RestaurantOwner, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.restaurantOwnerRepository;
	}

	

	@Override
	public List<RestaurantOwner> findByFirstName(String firstName) throws Exception {
		// TODO Auto-generated method stub
		return this.restaurantOwnerRepository.findByFirstName(firstName);
	}

}
