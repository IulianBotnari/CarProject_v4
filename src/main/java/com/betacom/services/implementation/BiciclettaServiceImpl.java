package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.BiciclettaDTOReq;
import com.betacom.dto.output.BiciclettaDTORes;
import com.betacom.enums.VehicleType;
import com.betacom.models.Bicicletta;
import com.betacom.models.Veicolo;
import com.betacom.repository.BiciclettaRepository;
import com.betacom.services.interfaces.InterfaceBiciclettaService;
import com.betacom.utils.CostruttoreDTORes;
import com.betacom.utils.CostruttoreModels;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class BiciclettaServiceImpl implements InterfaceBiciclettaService{
	
	
	private final BiciclettaRepository biciclettaRepo;
	private final CostruttoreModels models;
	
	
	@Override
	public List<BiciclettaDTORes> list() throws Exception {
		List<Bicicletta> listaBici = biciclettaRepo.findAll();
		
		return null;
	//	return listaBici.stream().map(bici -> CostruttoreDTORes.createBiciclettaDTORes(bicicletta)).collect(Collectors.toList());
	}
/*
	@Override
	public void create(BiciclettaDTOReq request) throws Exception {
		System.out.println("Bicicletta creata in create bicicletta impl" );
		Bicicletta result = new Bicicletta();
		models.populateVeicolo(result, request, VehicleType.BICICLETTA);
		result.setNumeroMarce(request.getNumeroMarce());
		result.setFreno(models.createFreno(request.getFreno()));
		result.setSospensione(models.createSospensione(request.getSospensione()));
		
		System.out.println("Bicicletta creata in create bicicletta impl" + result.toString());
		
		try {
			biciclettaRepo.save(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore durante il salvataggio della bicicletta: " + request.toString() + "\nErrore: " + e.getMessage());
		}
	
	 
		
	}*/
	
	
	@Override
	public void create(BiciclettaDTOReq request) throws Exception {
		System.out.println("Bicicletta creata in create bicicletta impl" );
		Bicicletta result = new Bicicletta();
		models.populateVeicolo(result, request, VehicleType.BICICLETTA);
		result.setNumeroMarce(request.getNumeroMarce());
		result.setFreno(models.createFreno(request.getFreno()));
		result.setSospensione(models.createSospensione(request.getSospensione()));
		
		System.out.println("Bicicletta creata in create bicicletta impl" + result.toString());
		
		try {
			biciclettaRepo.save(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore durante il salvataggio della bicicletta: " + request.toString() + "\nErrore: " + e.getMessage());
		}
	
	 
		
	}

	@Override
	public void update(BiciclettaDTOReq request) throws Exception {
		Bicicletta bici = biciclettaRepo.findById(request.getIdVeicolo()).orElseThrow(()-> new Exception("Bicicletta non trovata"));
		
		//bici = models.createBicicletta(request);
		
		biciclettaRepo.save(bici);
		
	}


	@Override
	public void delete(Integer id) throws Exception {
		Bicicletta bici = biciclettaRepo.findById(id).orElseThrow(()-> new Exception("Bicicletta non trovata"));
		biciclettaRepo.delete(bici);
	}


	@Override
	public List<BiciclettaDTORes> searchByTipoVeicolo(VehicleType tipoVeicolo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public List<BiciclettaDTORes> searchByTipoVeicolo(VehicleType tipoVeicolo) throws Exception {
		
		List<Bicicletta> lB = biciclettaRepo.searchByTipoVeicolo(tipoVeicolo);
		
			return lB.stream().map(bici -> CostruttoreDTORes.createBiciclettaDTORes(bici)).collect(Collectors.toList());

	}*/

}
