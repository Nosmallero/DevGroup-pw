package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.Order;

public interface OrderService extends CrudService<Order, Integer>{
	List<Order> findByCustomer(Integer id) throws Exception;
}
