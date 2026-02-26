package com.betacom.dto.output;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
public class MacchinaDTORes extends VeicoloDTORes {

	private Integer idMacchina;

	private Integer porte;

	private String targa;

	private Integer cilindrata;
}
