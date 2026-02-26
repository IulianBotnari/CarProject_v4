package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.FrenoDTOReq;
import com.betacom.dto.output.FrenoDTORes;
import com.betacom.models.Freno;
import com.betacom.repository.FrenoRepository;
import com.betacom.services.interfaces.InterfaceFrenoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class FrenoServiceImpl implements InterfaceFrenoService{
	
	
	private final FrenoRepository frenoRepo;
	
	
	@Override
	public List<FrenoDTORes> list() throws Exception {
		log.debug("list");
		
		List<Freno> freni = frenoRepo.findAll();
		
		return freni.stream().map(
				(f) -> FrenoDTORes.builder()
				.idFreno(f.getIdFreno())
				.freno(f.getFreno())
				.build()
				).collect(Collectors.toList());
	}

	@Override
	public void create(FrenoDTOReq request) throws Exception {
		log.debug("create {}", request);
		
		Freno freno = new Freno();
		try {
			freno.setFreno(request.getFreno().toUpperCase().trim());
		} catch (Exception e) {
			throw new Exception("Freno non valido " + e.getMessage());
		}
		
		frenoRepo.save(freno);
	}

	@Override
	public void update(FrenoDTOReq request) throws Exception {
		log.debug("update {}", request);
		
		Freno freno = frenoRepo.findById(request.getIdFreno()).orElseThrow(() -> new Exception("Freno non presente in DB"));
		
		if(request.getFreno() != null)
			freno.setFreno(request.getFreno());
		
		frenoRepo.save(freno);
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		
		Freno freno = frenoRepo.findById(id).orElseThrow(() -> new Exception("Freno non presente in DB"));

		frenoRepo.delete(freno);
	}

}
