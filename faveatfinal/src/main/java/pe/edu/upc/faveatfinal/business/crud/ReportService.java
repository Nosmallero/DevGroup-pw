package pe.edu.upc.faveatfinal.business.crud;

import java.util.List;


import pe.edu.upc.faveatfinal.model.entity.Report;

public interface ReportService extends CrudService<Report, Integer>{
	List<Report> findByRestaurant(Integer id) throws Exception;
}
