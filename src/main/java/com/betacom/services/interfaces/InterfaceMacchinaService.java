package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.MacchinaDTOReq;
import com.betacom.dto.output.MacchinaDTORes;
import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.enums.VehicleType;

public interface InterfaceMacchinaService {
	List<MacchinaDTORes> list() throws Exception;
	
	void create(MacchinaDTOReq request) throws Exception;
	
	void update(MacchinaDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
	
	List<MacchinaDTORes> searchByTipoVeicolo(VehicleType tipoVeicolo) throws Exception;

}
