package com.betacom.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoDTOReq extends VeicoloDTOReq{

	private String targa;

	private Integer cilindrata;
}
