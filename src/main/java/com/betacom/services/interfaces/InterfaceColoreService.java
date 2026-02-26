package com.betacom.services.interfaces;

import java.util.List;
import com.betacom.dto.input.ColoreDTOReq;
import com.betacom.dto.output.ColoreDTORes;

public interface InterfaceColoreService {
	List<ColoreDTORes> list() throws Exception;
	
	void create(ColoreDTOReq request) throws Exception;
	
	void update(ColoreDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
}
