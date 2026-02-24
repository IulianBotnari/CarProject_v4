package com.betacom.dto.output;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoDTORes {

	private Integer idMoto;

	private Integer idVeicolo;

	private String targa;

	private Integer cilindrata;
}
