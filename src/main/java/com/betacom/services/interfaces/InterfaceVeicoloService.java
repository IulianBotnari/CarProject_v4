package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.dto.output.VeicoloDTORes;

public interface InterfaceVeicoloService {
	
	List<VeicoloDTORes> list() throws Exception;
	
	void create(VeicoloDTOReq request) throws Exception;
	
	void update(VeicoloDTOReq request) throws Exception;
	
	void delete(VeicoloDTOReq request) throws Exception;
	
}
