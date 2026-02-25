package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.SospensioneDTOReq;
import com.betacom.dto.output.SospensioneDTORes;


public interface InterfaceSospensioneService {
	List<SospensioneDTORes> list() throws Exception;
	
	void create(SospensioneDTOReq request) throws Exception;
	
	void update(SospensioneDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
}
