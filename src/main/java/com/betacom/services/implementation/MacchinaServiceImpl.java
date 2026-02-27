package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.MacchinaDTOReq;
import com.betacom.dto.output.MacchinaDTORes;
import com.betacom.enums.VehicleType;
import com.betacom.models.Macchina;
import com.betacom.repository.MacchinaRepository;
import com.betacom.services.interfaces.InterfaceMacchinaService;
import com.betacom.utils.CostruttoreDTORes;
import com.betacom.utils.CostruttoreModels;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class MacchinaServiceImpl implements InterfaceMacchinaService{
	
	private final MacchinaRepository macchinaRepo;
	private final CostruttoreModels models;
	
	@Override
	public List<MacchinaDTORes> list() throws Exception {

	    List<Macchina> lM = macchinaRepo.findAll();
	    
	    return lM.stream()
	            .map(mac -> CostruttoreDTORes.createMacchinaaDTORes(mac))
	            .collect(Collectors.toList());
	    
	}

	@Override
	public void create(MacchinaDTOReq request) throws Exception {
		log.debug("create {}", request);
		
		Macchina mac = new Macchina();
		models.populateVeicolo(mac, request, VehicleType.MACCHINA);
		mac.setPorte(request.getPorte());
		mac.setTarga(request.getTarga());
		mac.setCilindrata(request.getCilindrata());
		
		macchinaRepo.save(mac);
	}

	@Override
	public void update(MacchinaDTOReq request) throws Exception {
		log.debug("update {}", request);
		
		Macchina mac = macchinaRepo.findById(request.getIdVeicolo()).orElseThrow(() -> new Exception("Macchina non trovata"));
		models.updateVeicolo(mac, request);
		
		if(request.getPorte() != null)
			mac.setPorte(request.getPorte());
		if(request.getTarga() != null)
			mac.setTarga(request.getTarga());
		if(request.getCilindrata() != null)
			mac.setCilindrata(request.getCilindrata());
		
		macchinaRepo.save(mac);
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Macchina mac = macchinaRepo.findById(id).orElseThrow(() -> new Exception("Macchina non trovata"));
	
		macchinaRepo.delete(mac);
	}

}
