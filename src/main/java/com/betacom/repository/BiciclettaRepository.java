package com.betacom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.enums.VehicleType;
import com.betacom.models.Bicicletta;
import com.betacom.models.Veicolo;

@Repository
public interface BiciclettaRepository extends JpaRepository<Bicicletta, Integer>{
	/*@Query(name = "select.veicoloFilter")
	List<Bicicletta> searchByTipoVeicolo(@Param("tipoVeicolo") VehicleType tipoVeicolo);*/
}
