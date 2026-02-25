package com.betacom.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
@ToString
public class MotoDTORes extends VeicoloDTORes{

	private String targa;

	private Integer cilindrata;
}
