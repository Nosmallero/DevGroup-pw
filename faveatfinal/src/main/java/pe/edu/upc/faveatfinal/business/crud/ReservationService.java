package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;

import pe.edu.upc.faveatfinal.model.entity.Reservation;

public interface ReservationService extends CrudService<Reservation, Integer>{

	List<Reservation> findByCustomer(Integer id) throws Exception;

}
