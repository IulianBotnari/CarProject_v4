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
@Table(name = "alimentzioni")
@Getter
@Setter
public class Alimentazione {
	
	@Id
	@Column(name = "id_alimentazione")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlimentazione;
	
	@Column(name = "alimentazione", nullable = false)
	private String alimentazione;

}
