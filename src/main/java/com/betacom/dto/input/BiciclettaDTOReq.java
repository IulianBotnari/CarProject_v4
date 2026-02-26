package com.betacom.dto.input;

import com.betacom.models.Freno;
import com.betacom.models.Sospensione;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BiciclettaDTOReq extends VeicoloDTOReq{

	private Integer numeroMarce;

	private Integer freno;

	private Integer sospensione;
	
}
