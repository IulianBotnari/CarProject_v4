package com.betacom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.models.Alimentazione;

@Repository
public interface AlimentazioneRepository extends JpaRepository<Alimentazione, Integer> {

}
