package com.betacom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "biciclette")
public class Bicicletta extends Veicolo{
	
	@Column(name = "id_veicolo", nullable = false)
	private Integer idVeicolo;
	
	@Column(name = "numero_marce", nullable = false)
	private Integer numeroMarce;
	
	@OneToOne
	@JoinColumn(name = "id_freno")
	private Freno idFreno;
	

	@OneToOne
	@JoinColumn(name = "id_sospensione")
	private Sospensione idSospensione;
	
}
