package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.betacom.controller.FrenoController;
import com.betacom.dto.input.ColoreDTOReq;
import com.betacom.dto.output.ColoreDTORes;
import com.betacom.models.Colore;
import com.betacom.models.Freno;
import com.betacom.repository.ColoreRepository;
import com.betacom.services.interfaces.InterfaceColoreService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class ColoreServieImpl implements InterfaceColoreService {

	private final ColoreRepository coloreRepo;

	@Override
	public List<ColoreDTORes> list() throws Exception {
		log.debug("list");
		
		List<Colore> colori = coloreRepo.findAll();
		
		return colori.stream().map(c -> 
				ColoreDTORes.builder()
				.idColore(c.getIdColore())
				.colore(c.getColore())
				.build()
				).collect(Collectors.toList());
	}

	@Override
	public void create(ColoreDTOReq request) throws Exception {
		log.debug("create {}", request);

		Colore colore = new Colore();
		try {
			colore.setColore(request.getColore().toUpperCase().trim());
		} catch (Exception e) {
			throw new Exception("Colore non valido " + e.getMessage());
		}

		coloreRepo.save(colore);
	}

	@Override
	public void update(ColoreDTOReq request) throws Exception {
		log.debug("update {}", request);

		Colore colore= coloreRepo.findById(request.getIdColore())
				.orElseThrow(() -> new Exception("Colore non presente in DB"));

		if (request.getColore() != null)
			colore.setColore(request.getColore().toUpperCase().trim());

		coloreRepo.save(colore);
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);

		Colore colore= coloreRepo.findById(id)
				.orElseThrow(() -> new Exception("Colore non presente in DB"));
		
		coloreRepo.delete(colore);
	}

}
