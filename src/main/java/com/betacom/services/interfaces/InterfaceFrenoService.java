package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.FrenoDTOReq;
import com.betacom.dto.output.FrenoDTORes;

public interface InterfaceFrenoService {
	List<FrenoDTORes> list() throws Exception;
	
	void create(FrenoDTOReq request) throws Exception;
	
	void update(FrenoDTOReq request) throws Exception;
	
	void delete(FrenoDTOReq request) throws Exception;
}
