package com.betacom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.models.Colore;

@Repository
public interface ColoreRepository extends JpaRepository<Colore, Integer>{

}
