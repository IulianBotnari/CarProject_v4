package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.CategoriaDTOReq;
import com.betacom.dto.output.CategoriaDTORes;
import com.betacom.repository.CategoriaRepository;
import com.betacom.services.interfaces.InterfaceCategoriaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements InterfaceCategoriaService{
	
	
	private final CategoriaRepository categoriaRepo;
	
	
	@Override
	public List<CategoriaDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(CategoriaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CategoriaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CategoriaDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
