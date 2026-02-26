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
	
	private Integer alimentazione;
	
	private Integer categoria;

	private Integer colore;

	private String marca;

	private Integer annoProduzione;

	private String modello;
}
