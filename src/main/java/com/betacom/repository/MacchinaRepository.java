package com.betacom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.models.Macchina;

@Repository
public interface MacchinaRepository extends JpaRepository<Macchina, Integer>{

}
