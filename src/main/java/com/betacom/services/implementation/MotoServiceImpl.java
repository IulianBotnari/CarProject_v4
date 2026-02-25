package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.output.MotoDTORes;
import com.betacom.models.Moto;
import com.betacom.repository.MotoRepository;
import com.betacom.services.interfaces.InterfaceMotoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MotoServiceImpl implements InterfaceMotoService{
	
	private final MotoRepository motoRepo;
	
	
	@Override
	public List<MotoDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(MotoDTOReq request) throws Exception {
	 
		
	}

	@Override
	public void update(MotoDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MotoDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
