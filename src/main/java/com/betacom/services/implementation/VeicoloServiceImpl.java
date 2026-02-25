package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.repository.VeicoloRepository;
import com.betacom.services.interfaces.InterfaceVeicoloService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class VeicoloServiceImpl implements InterfaceVeicoloService{
	
	private final VeicoloRepository veicoloRepo;

	@Override
	public List<VeicoloDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(VeicoloDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(VeicoloDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(VeicoloDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
