package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.enums.VehicleType;

public interface InterfaceVeicoloService {
	
	List<? extends VeicoloDTORes> multiFilter(Integer idVeicolo,
			String marca,
			String modello,
			VehicleType tipoVeicolo,
			Integer idAlimentazione,
			Integer idCategoria,
			Integer annoProduzione,
			Integer idColore,
			Integer numeroRuote,
			String targa) throws Exception;
	
}
