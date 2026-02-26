package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.MacchinaDTOReq;
import com.betacom.dto.output.MacchinaDTORes;

public interface InterfaceMacchinaService {
	List<MacchinaDTORes> list() throws Exception;
	
	void create(MacchinaDTOReq request) throws Exception;
	
	void update(MacchinaDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
}
