package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;


import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;

public interface DeliveryManService extends CrudService<DeliveryMan, Integer>{
	List<DeliveryMan> findByLastName(String lastName) throws Exception;
}
