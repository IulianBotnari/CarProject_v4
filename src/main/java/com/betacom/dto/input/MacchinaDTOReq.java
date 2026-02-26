package com.betacom.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MacchinaDTOReq extends VeicoloDTOReq {


	private Integer porte;

	private String targa;

	private Integer cilindrata;
}
