package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.BiciclettaDTOReq;
import com.betacom.dto.output.BiciclettaDTORes;
import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.enums.VehicleType;

public interface InterfaceBiciclettaService {
	List<BiciclettaDTORes> list() throws Exception;
	
	void create(BiciclettaDTOReq request) throws Exception;
	
	void update(BiciclettaDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
	
	List<BiciclettaDTORes> searchByTipoVeicolo(VehicleType tipoVeicolo) throws Exception;

}
