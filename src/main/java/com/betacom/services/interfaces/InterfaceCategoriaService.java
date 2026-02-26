package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.CategoriaDTOReq;
import com.betacom.dto.output.CategoriaDTORes;

public interface InterfaceCategoriaService {
	List<CategoriaDTORes> list() throws Exception;
	
	void create(CategoriaDTOReq request) throws Exception;
	
	void update(CategoriaDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
}
