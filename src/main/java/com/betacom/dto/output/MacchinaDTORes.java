package com.betacom.dto.output;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MacchinaDTORes {

	private Integer idMacchina;

	private Integer idVeicolo;

	private Integer porte;

	private String targa;

	private Integer cilindrata;
}
