package com.betacom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.models.Sospensione;

@Repository
public interface SospensioneRepository extends JpaRepository<Sospensione, Integer>{

}
