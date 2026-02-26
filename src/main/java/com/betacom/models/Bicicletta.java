package com.betacom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Getter
@Setter
@Table(name = "biciclette")
public class Bicicletta extends Veicolo{
	
	@Column(name = "numero_marce", nullable = false)
	private Integer numeroMarce;
	
	@OneToOne
	@JoinColumn(name = "id_freno")
	private Freno freno;
	

	@OneToOne
	@JoinColumn(name = "id_sospensione")
	private Sospensione sospensione;
	
}