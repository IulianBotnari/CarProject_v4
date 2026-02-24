package com.betacom.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BiciclettaDTOReq {

	private Integer idBiciletta;

	private Integer idVeicolo;

	private Integer numeroMarce;

	private Integer idFreno;

	private Integer idSospensione;
	
}
