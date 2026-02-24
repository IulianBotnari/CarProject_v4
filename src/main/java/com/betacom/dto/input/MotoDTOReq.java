package com.betacom.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoDTOReq {
	

	private Integer idMoto;

	private Integer idVeicolo;

	private String targa;

	private Integer cilindrata;
}
