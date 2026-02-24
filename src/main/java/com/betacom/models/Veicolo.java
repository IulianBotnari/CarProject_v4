package com.betacom.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "veicoli")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veicolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veicolo")
	private Integer idVeicolo;
	
	@Column(name = "tipo_veicolo", length = 50, nullable = false)
	private String tipoVeicolo;
	
	@Column(name = "numero_ruote", nullable = false)
	private Integer numeroRuote;
	
	@Column(name = "id_alimentazione", nullable = false)
	private Integer idAlimentazione;
	
	@Column(name = "id_categoria", nullable = false)
	private Integer idCategoria;
	
	@Column(name = "id_colore", nullable = false)
	private Integer idColore;
	
	@Column(name = "marca", nullable = false)
	private String marca;
	
	@Column(name = "anno_produzione", nullable = false)
	private Integer annoProduzione;
	
	@Column(name = "modello", nullable = false)
	private String modello;
	

}
