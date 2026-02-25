package com.betacom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.models.Freno;

@Repository
public interface FrenoRepository extends JpaRepository<Freno, Integer> {

}
