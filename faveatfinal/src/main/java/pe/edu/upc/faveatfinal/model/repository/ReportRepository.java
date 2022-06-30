package pe.edu.upc.faveatfinal.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Report;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{
	List<Report> findByRestaurant(Restaurant restaurant) throws Exception;
}
