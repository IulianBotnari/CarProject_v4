package com.betacom.dto.output;



import com.betacom.models.Alimentazione;
import com.betacom.models.Categoria;
import com.betacom.models.Colore;

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
	
	private String tipoVeicolo;

	private Integer numeroRuote;
	
	private Alimentazione alimentazione;
	
	private Categoria categoria;

	private Colore colore;

	private String marca;

	private Integer annoProduzione;

	private String modello;
	
	
}
