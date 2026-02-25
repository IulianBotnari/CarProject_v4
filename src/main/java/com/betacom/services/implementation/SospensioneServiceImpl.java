package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

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
		List<Sospensione> listaSospensione = sospensioneRepo.findAll();
		
		
		return listaSospensione.stream().map(sosp -> SospensioneDTORes.builder()
				.idSospensione(sosp.getIdSospensione())
				.sospensione(sosp.getSospensione())
				.build()).collect(Collectors.toList());
	}

	@Override
	public void create(SospensioneDTOReq request) throws Exception {
		
		Sospensione sospensione = new Sospensione();
		
		
		try {
			sospensione.setSospensione(request.getSospensione().toUpperCase().trim());
		} catch (Exception e) {
			throw new Exception("Sospensione non valida " + e.getMessage());
		}
		
		sospensioneRepo.save(sospensione);
		
	}

	@Override
	public void update(SospensioneDTOReq request) throws Exception {
		
		
		
		if (request.getIdSospensione() == null) {
			throw new Exception("Il campo id non puo essere vuoto");
		}
		
		Sospensione sospensione = sospensioneRepo.findById(request.getIdSospensione()).orElseThrow(() -> new Exception("Sospensione non presnte in DB"));
		if (request.getSospensione() != null) {
			sospensione.setSospensione(request.getSospensione().toUpperCase().trim());
		}

		sospensioneRepo.save(sospensione);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		Sospensione sospensione = sospensioneRepo.findById(id).orElseThrow(() -> new Exception("Sospensione non presnte in DB"));
		sospensioneRepo.delete(sospensione);
		
		
	}

}
