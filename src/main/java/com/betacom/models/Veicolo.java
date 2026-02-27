package com.betacom.models;


import com.betacom.enums.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Entity
@Table(name = "veicoli")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Veicolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veicolo")
	private Integer idVeicolo;
	
	@Column(name = "tipo_veicolo", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private VehicleType tipoVeicolo;
	
	@Column(name = "numero_ruote", nullable = false)
	private Integer numeroRuote;
	

	@ManyToOne
	@JoinColumn(name = "alimentazione")
	private Alimentazione alimentazione;
	
	@ManyToOne
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "colore")
	private Colore colore;
	
	@Column(name = "marca", nullable = false)
	private String marca;
	
	@Column(name = "anno_produzione", nullable = false)
	private Integer annoProduzione;
	
	@Column(name = "modello", nullable = false)
	private String modello;
	

}
