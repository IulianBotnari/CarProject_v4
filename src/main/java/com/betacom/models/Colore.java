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
@Table(name = "colori")
@Getter
@Setter
public class Colore {
	
	@Id
	@Column(name = "id_colore")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idColore;
	
	@Column(name = "colore", nullable = false)
	private String colore;

}
