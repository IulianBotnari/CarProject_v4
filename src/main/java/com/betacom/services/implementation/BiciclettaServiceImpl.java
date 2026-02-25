package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.BiciclettaDTOReq;
import com.betacom.dto.output.BiciclettaDTORes;
import com.betacom.repository.BiciclettaRepository;
import com.betacom.services.interfaces.InterfaceBiciclettaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BiciclettaServiceImpl implements InterfaceBiciclettaService{
	
	
	private final BiciclettaRepository biciclettaRepo;
	
	
	@Override
	public List<BiciclettaDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(BiciclettaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BiciclettaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BiciclettaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
