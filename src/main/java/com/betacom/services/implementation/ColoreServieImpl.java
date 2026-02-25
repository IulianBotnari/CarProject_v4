package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.ColoreDTOReq;
import com.betacom.dto.output.ColoreDTORes;
import com.betacom.repository.ColoreRepository;
import com.betacom.services.interfaces.InterfaceColoreService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ColoreServieImpl implements InterfaceColoreService{
	
	
	private final ColoreRepository coloreRepo;
	
	
	@Override
	public List<ColoreDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(ColoreDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ColoreDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ColoreDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
