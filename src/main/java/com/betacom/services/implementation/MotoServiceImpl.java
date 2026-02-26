package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.output.MotoDTORes;
import com.betacom.models.Moto;
import com.betacom.repository.MotoRepository;
import com.betacom.services.interfaces.InterfaceMotoService;
import com.betacom.utils.CostruttoreDTORes;
import com.betacom.utils.CostruttoreModels;
import com.betacom.utils.Validazioni;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MotoServiceImpl implements InterfaceMotoService{
	
	private final MotoRepository motoRepo;
	private final CostruttoreModels models;
	private final Validazioni validazioni;
	
	
	@Override
	public List<MotoDTORes> list() throws Exception {
		List<Moto> listaMoto = motoRepo.findAll();
		
		
		return listaMoto.stream().map(moto -> CostruttoreDTORes.createMotoDTORes(moto)).collect(Collectors.toList());
	}

	@Override
	public void create(MotoDTOReq request) throws Exception {
		System.out.println("Moto creata in create moto impl" );
		Moto result = models.createMoto(request);
		
		System.out.println("Moto creata in create moto impl" + result.toString());
		
		try {
			motoRepo.save(result);
		} catch (Exception e) {
			System.out.println("Errore durante il salvataggio della moto: " + request.toString() + "\nErrore: " + e.getMessage());
		}
	
	 
		
	}

	@Override
	public void update(MotoDTOReq request) throws Exception {
		models.validaMotoUpdate(request);		
	}

	@Override
	public void delete(Integer id) throws Exception {
		Moto moto = motoRepo.findById(id).orElseThrow(()-> new Exception("Moto non trovata"));
		motoRepo.delete(moto);
	}

}
