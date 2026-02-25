package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.AlimentazioneDTOReq;
import com.betacom.dto.output.AlimentazioneDTORes;
import com.betacom.repository.AlimentazioneRepository;
import com.betacom.services.interfaces.InterfaceAlimentazioneService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AlimentazioneServiceImpl implements InterfaceAlimentazioneService{
	
	
	private final AlimentazioneRepository alimentazioneRepo;
	
	
	@Override
	public List<AlimentazioneDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(AlimentazioneDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AlimentazioneDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AlimentazioneDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
