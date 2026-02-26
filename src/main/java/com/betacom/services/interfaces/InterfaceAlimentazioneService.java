package com.betacom.services.interfaces;

import java.util.List;
import com.betacom.dto.input.AlimentazioneDTOReq;
import com.betacom.dto.output.AlimentazioneDTORes;

public interface InterfaceAlimentazioneService {
	List<AlimentazioneDTORes> list() throws Exception;
	
	void create(AlimentazioneDTOReq request) throws Exception;
	
	void update(AlimentazioneDTOReq request) throws Exception;
	
	void delete(Integer id) throws Exception;
}
