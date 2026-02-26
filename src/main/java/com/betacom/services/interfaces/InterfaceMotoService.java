package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.output.MacchinaDTORes;
import com.betacom.dto.output.MotoDTORes;
import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.enums.VehicleType;

public interface InterfaceMotoService {
	List<MotoDTORes> list() throws Exception;
	
	void create(MotoDTOReq request) throws Exception;
	
	void update(MotoDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
	
	List<MotoDTORes> searchByTipoVeicolo(VehicleType tipoVeicolo) throws Exception;

}
