package com.betacom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sospensioni")
@Getter
@Setter
public class Sospensione {
	
	
	@Id
	@Column(name = "id_sospensione")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSospensione;
	
	@Column(name = "sospensione", nullable = false)
	private String sospensione;
}
