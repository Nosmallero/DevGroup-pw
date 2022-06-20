package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.DeliveryPaymentService;
import pe.edu.upc.faveatfinal.model.entity.DeliveryPayment;
import pe.edu.upc.faveatfinal.model.repository.DeliveryPaymentRepository;

@Service
public class DeliveryPaymentServiceImpl implements DeliveryPaymentService{

	@Autowired
	private DeliveryPaymentRepository deliveryPaymentRepository;
	
	@Override
	public JpaRepository<DeliveryPayment, Integer> getJpaRepository() {
		return this.deliveryPaymentRepository;
	}

	@Override
	public List<DeliveryPayment> findByIdAndNameDelivery(Integer id, String nameDelivery) throws Exception {
		return this.deliveryPaymentRepository.findByIdAndNameDelivery(id, nameDelivery);
	}

}
