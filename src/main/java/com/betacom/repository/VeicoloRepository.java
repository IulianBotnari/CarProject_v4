package com.betacom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.enums.VehicleType;
import com.betacom.models.Veicolo;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Integer>{
	
	@Query(name = "select.multiFilter")
	public List<Veicolo> multiFilter(@Param("idVeicolo") Integer idVeicolo,
			@Param("marca") String marca,
			@Param("modello") String modello,
			@Param("tipoVeicolo") VehicleType tipoVeicolo,
			@Param("idAlimentazione") Integer idAlimentazione,
			@Param("idCategoria") Integer idCategoria,
			@Param("annoProduzione") Integer annoProduzione,
			@Param("idColore") Integer idColore,
			@Param("numeroRuote") Integer numeroRuote,
	        @Param("targa") String targa);
}
