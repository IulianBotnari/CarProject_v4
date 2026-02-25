package com.betacom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.models.Bicicletta;

@Repository
public interface BiciclettaRepository extends JpaRepository<Bicicletta, Integer>{

}
