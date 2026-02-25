package com.betacom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.models.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer>{

}
