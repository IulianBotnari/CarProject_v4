package com.betacom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Entity
@Table(name = "moto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Moto extends Veicolo {
	
	
	@Size(min = 5, max = 5, message = "Il campo prevede cinque caratteri")
	@Column(name = "targa", nullable = false, unique = true, length = 5)
	private String targa;
	
	@Column(name = "cilindrata", nullable = false)
	private Integer cilindrata;
}
