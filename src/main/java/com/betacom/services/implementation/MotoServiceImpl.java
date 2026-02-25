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

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MotoServiceImpl implements InterfaceMotoService{
	
	private final MotoRepository motoRepo;
	
	
	@Override
	public List<MotoDTORes> list() throws Exception {
		List<Moto> listaMoto = motoRepo.findAll();
		
		
		return listaMoto.stream().map(moto -> CostruttoreDTORes.createMotoDTORes(moto)).collect(Collectors.toList());
	}

	@Override
	public void create(MotoDTOReq request) throws Exception {
		
		Moto result = CostruttoreModels.createMoto(request);
		result.setIdVeicolo(null);
		
		try {
			motoRepo.save(result);
		} catch (Exception e) {
			System.out.println("Errore durante il salvataggio della moto: " + request.getTarga() + "\nErrore: " + e.getMessage());
		}
	
	 
		
	}

	@Override
	public void update(MotoDTOReq request) throws Exception {
		Moto moto = motoRepo.findById(request.getIdVeicolo()).orElseThrow(()-> new Exception("Moto non trovata"));
		
		moto = CostruttoreModels.createMoto(request);
		
		motoRepo.save(moto);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		Moto moto = motoRepo.findById(id).orElseThrow(()-> new Exception("Moto non trovata"));
		motoRepo.delete(moto);
	}

}
