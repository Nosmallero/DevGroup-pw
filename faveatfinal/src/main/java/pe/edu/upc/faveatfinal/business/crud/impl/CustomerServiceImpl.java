package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.CustomerService;
import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.repository.CustomerRepository;




@Service

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public JpaRepository<Customer, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.customerRepository;
	}

	@Override
	public List<Customer> findByLastName(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return this.customerRepository.findByLastName(lastName);
	}

}
