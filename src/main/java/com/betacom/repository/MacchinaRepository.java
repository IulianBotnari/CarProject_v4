package com.betacom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.enums.VehicleType;
import com.betacom.models.Macchina;

@Repository
public interface MacchinaRepository extends JpaRepository<Macchina, Integer>{
	/*@Query(name = "select.veicoloFilter")
	List<Macchina> searchByTipoVeicolo(@Param("tipoVeicolo") VehicleType tipoVeicolo);*/
}
