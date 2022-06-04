
package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.Customer;



public interface CustomerService extends CrudService<Customer, Integer>{
	List<Customer> findByLastName(String lastName) throws Exception;
}
