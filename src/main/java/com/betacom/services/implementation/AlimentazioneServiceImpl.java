package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.AlimentazioneDTOReq;
import com.betacom.dto.output.AlimentazioneDTORes;
import com.betacom.models.Alimentazione;
import com.betacom.repository.AlimentazioneRepository;
import com.betacom.services.interfaces.InterfaceAlimentazioneService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class AlimentazioneServiceImpl implements InterfaceAlimentazioneService{
	
	
	private final AlimentazioneRepository alimentazioneRepo;
	
	
	@Override
	public List<AlimentazioneDTORes> list() throws Exception {
		log.debug("list");
		
		List<Alimentazione> alim = alimentazioneRepo.findAll();
		
		return alim.stream().map(a -> AlimentazioneDTORes.builder()
				.idAlimentazione(a.getIdAlimentazione())
				.alimentazione(a.getAlimentazione())
				.build()
				).collect(Collectors.toList());
	}

	@Override
	public void create(AlimentazioneDTOReq request) throws Exception {
		log.debug("create {}", request);
		
		Alimentazione ali = Alimentazione.builder().alimentazione(request.getAlimentazione()).build();
		
		alimentazioneRepo.save(ali);
	}

	@Override
	public void update(AlimentazioneDTOReq request) throws Exception {
		log.debug("update {}", request);
		
		if (request.getIdAlimentazione() == null) 
			throw new Exception("Il campo id non puo essere vuoto");
		
		Alimentazione alim = alimentazioneRepo.findById(request.getIdAlimentazione()).orElseThrow(() -> new Exception("Alimentazione non presente in DB"));
		
		if (request.getAlimentazione() != null)
			alim.setAlimentazione(request.getAlimentazione());
		
		alimentazioneRepo.save(alim);
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		
		Alimentazione alim = alimentazioneRepo.findById(id).orElseThrow(() -> new Exception("Alimentazione non presente in DB"));
		
		alimentazioneRepo.delete(alim);
	}

}
