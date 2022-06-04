package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.ReservationPayment;

public interface ReservationPaymentService extends CrudService<ReservationPayment, Integer>{
	List<ReservationPayment> findByIdAndNameReservation(Integer id, String nameReservation) throws Exception;

}
