package pe.edu.upc.faveatfinal.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.ReportService;
import pe.edu.upc.faveatfinal.model.entity.Report;
import pe.edu.upc.faveatfinal.model.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	public JpaRepository<Report, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.reportRepository;
	}
	@Override
	public List<Report> findByLastName(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return this.reportRepository.findByLastName(lastName);
	}
}
