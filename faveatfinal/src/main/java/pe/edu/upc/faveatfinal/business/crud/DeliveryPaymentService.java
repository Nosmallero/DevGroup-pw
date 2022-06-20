package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.DeliveryPayment;

public interface DeliveryPaymentService extends CrudService<DeliveryPayment, Integer>{
	List<DeliveryPayment> findByIdAndNameDelivery(Integer id, String nameDelivery) throws Exception;

}
