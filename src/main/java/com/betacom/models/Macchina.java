package com.betacom.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
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
@Table(name = "macchine")
public class Macchina extends Veicolo {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_macchina")
//	private Integer idMacchina;
	
	@Column(name = "porte", nullable = false)
	private Integer porte;
	
	@Size(min = 7, max = 7, message = "Il campo prevede sette caratteri")
	@Column(name = "targa", nullable = false, unique = true, length = 7)
	private String targa;
	
	@Column(name = "cilindrata", nullable = false)
	private Integer cilindrata;
	
}
