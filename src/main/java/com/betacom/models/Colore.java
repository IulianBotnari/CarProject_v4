package com.betacom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Entity
@Table(name = "colori")
@Getter
@Setter
public class Colore {
	
	@Id
	@Column(name = "id_colore")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idColore;
	
	@Column(name = "colore", nullable = false, unique = true)
	private String colore;

}
