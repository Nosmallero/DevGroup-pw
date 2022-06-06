package pe.edu.upc.faveatfinal.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.business.crud.MesasService;
import pe.edu.upc.faveatfinal.model.entity.Mesas;
import pe.edu.upc.faveatfinal.model.repository.MesasRepository;

@Service
public class MesasServiceImpl implements MesasService{
	@Autowired
	private MesasRepository mesasRepository;
	
	@Override
	public JpaRepository<Mesas, Integer> getJpaRepository() {
		return this.mesasRepository;
	}

}