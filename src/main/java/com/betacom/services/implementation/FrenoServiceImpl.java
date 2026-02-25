package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.FrenoDTOReq;
import com.betacom.dto.output.FrenoDTORes;
import com.betacom.repository.FrenoRepository;
import com.betacom.services.interfaces.InterfaceFrenoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FrenoServiceImpl implements InterfaceFrenoService{
	
	
	private final FrenoRepository frenoRepo;
	
	
	@Override
	public List<FrenoDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(FrenoDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FrenoDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FrenoDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
