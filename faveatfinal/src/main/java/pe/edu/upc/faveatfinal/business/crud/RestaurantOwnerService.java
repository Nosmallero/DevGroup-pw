package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.RestaurantOwner;

public interface RestaurantOwnerService extends CrudService<RestaurantOwner, Integer>{
	List<RestaurantOwner> findByFirstName(String firstName) throws Exception;
}
