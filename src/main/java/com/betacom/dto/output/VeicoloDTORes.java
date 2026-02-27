package com.betacom.dto.output;



import com.betacom.enums.VehicleType;
import com.betacom.models.Alimentazione;
import com.betacom.models.Categoria;
import com.betacom.models.Colore;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString

public class VeicoloDTORes {
	private Integer idVeicolo;
	
	private VehicleType tipoVeicolo;
	
	private Integer numeroRuote;
	
	private Alimentazione alimentazione;
	
	private Categoria categoria;

	private Colore colore;

	private String marca;

	private Integer annoProduzione;

	private String modello;
	
	
}
