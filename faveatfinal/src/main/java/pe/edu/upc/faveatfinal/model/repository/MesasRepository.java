package pe.edu.upc.faveatfinal.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.faveatfinal.model.entity.Mesas;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Integer>{

}