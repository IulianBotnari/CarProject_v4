package com.betacom.dto.output;

import com.betacom.models.Freno;
import com.betacom.models.Sospensione;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
public class BiciclettaDTORes extends VeicoloDTORes{

	private Integer numeroMarce;

	private Freno freno;

	private Sospensione sospensione;
	
	
	
}
