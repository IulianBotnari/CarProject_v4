package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.SospensioneDTOReq;
import com.betacom.dto.output.SospensioneDTORes;
import com.betacom.models.Sospensione;
import com.betacom.repository.SospensioneRepository;
import com.betacom.services.interfaces.InterfaceSospensioneService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class SospensioneServiceImpl implements InterfaceSospensioneService{
	
	private final SospensioneRepository sospensioneRepo;
	
	
	@Override
	public List<SospensioneDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(SospensioneDTOReq request) throws Exception {
		// log.debug("Crea sospensione {}", request);
		
		System.out.println(request);
		
		Sospensione sospensione = new Sospensione();
		
		
		try {
			sospensione.setSospensione(request.getSospensione().trim().toUpperCase());
		} catch (Exception e) {
			throw new Exception("Sospensione non valida " + e.getMessage());
		}
		
		sospensioneRepo.save(sospensione);
		
	}

	@Override
	public void update(SospensioneDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SospensioneDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
