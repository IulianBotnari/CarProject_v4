package com.betacom.dto.output;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString
public class CategoriaDTORes {
	private Integer idCategoria;

	private String categoria;
}
