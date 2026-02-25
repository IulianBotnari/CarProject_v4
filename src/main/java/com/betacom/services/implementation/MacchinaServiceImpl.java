package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.MacchinaDTOReq;
import com.betacom.dto.output.MacchinaDTORes;
import com.betacom.repository.MacchinaRepository;
import com.betacom.services.interfaces.InterfaceMacchinaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MacchinaServiceImpl implements InterfaceMacchinaService{
	
	private final MacchinaRepository macchinaRepo;
	
	
	@Override
	public List<MacchinaDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(MacchinaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MacchinaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MacchinaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
