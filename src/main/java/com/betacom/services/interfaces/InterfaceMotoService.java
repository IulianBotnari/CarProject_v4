package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.output.MotoDTORes;

public interface InterfaceMotoService {
	List<MotoDTORes> list() throws Exception;
	
	void create(MotoDTOReq request) throws Exception;
	
	void update(MotoDTOReq request) throws Exception;
	
	void delete(MotoDTOReq request) throws Exception;
}
