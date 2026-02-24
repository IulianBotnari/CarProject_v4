package com.betacom.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
	

	@OneToOne
	@JoinColumn(name = "id_alimentazione")
	private Alimentazione idAlimentazione;
	
	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria idCategoria;
	@OneToOne
	@JoinColumn(name = "id_colore")
	private Colore idColore;
	
	@Column(name = "marca", nullable = false)
	private String marca;
	
	@Column(name = "anno_produzione", nullable = false)
	private Integer annoProduzione;
	
	@Column(name = "modello", nullable = false)
	private String modello;
	

}
