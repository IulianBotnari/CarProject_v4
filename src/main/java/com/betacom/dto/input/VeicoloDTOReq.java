package com.betacom.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VeicoloDTOReq {
	
	private Integer idVeicolo;
	
	private String tipoVeicolo;

	private Integer numeroRuote;
	
	private Integer idAlimentazione;
	
	private Integer idCategoria;

	private Integer idColore;

	private String marca;

	private Integer annoProduzione;

	private String modello;
}
