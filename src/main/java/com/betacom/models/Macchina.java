package com.betacom.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Entity
@Getter
@Setter
@Table(name = "macchine")
public class Macchina extends Veicolo {
	
	@Column(name = "porte", nullable = false)
	private Integer porte;
	
	@Size(min = 7, max = 7, message = "Il campo prevede sette caratteri")
	@Column(name = "targa", nullable = false, unique = true, length = 7)
	private String targa;
	
	@Column(name = "cilindrata", nullable = false)
	private Integer cilindrata;
	
}
