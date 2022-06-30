package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.ReportService;
import pe.edu.upc.faveatfinal.model.entity.Report;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.repository.ReportRepository;
import pe.edu.upc.faveatfinal.model.repository.RestaurantRepository;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
    private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	public JpaRepository<Report, Integer> getJpaRepository() {
		
		// TODO Auto-generated method stub
		return this.reportRepository;
	}
	@Override
    public List<Report> findByRestaurant(Integer id) throws Exception {
        // TODO Auto-generated method stub
        if(restaurantRepository.existsById(id)) {
            Optional<Restaurant> optional = restaurantRepository.findById(id);
            return reportRepository.findByRestaurant(optional.get());
        } else {
            return new ArrayList<Report>();
        }

    }
}
