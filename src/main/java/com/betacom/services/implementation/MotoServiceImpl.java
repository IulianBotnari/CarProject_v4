package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.output.MotoDTORes;
import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.enums.VehicleType;
import com.betacom.models.Moto;
import com.betacom.models.Veicolo;
import com.betacom.repository.MotoRepository;
import com.betacom.services.interfaces.InterfaceMotoService;
import com.betacom.utils.CostruttoreDTORes;
import com.betacom.utils.CostruttoreModels;
import com.betacom.utils.Validazioni;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MotoServiceImpl implements InterfaceMotoService {

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
		System.out.println("Moto creata in create moto impl");
		Moto result = new Moto();
		models.populateVeicolo(result, request, VehicleType.MOTO);
		result.setTarga(request.getTarga());
		result.setCilindrata(request.getCilindrata());

		System.out.println("Moto creata in create moto impl" + result.toString());

		try {
			motoRepo.save(result);
		} catch (Exception e) {
			System.out.println(
					"Errore durante il salvataggio della moto: " + request.toString() + "\nErrore: " + e.getMessage());
		}

	}

	@Override
	public void update(MotoDTOReq request) throws Exception {
		Moto mac = motoRepo.findById(request.getIdVeicolo()).orElseThrow(() -> new Exception("Moto non trovata"));
		models.updateVeicolo(mac, request);

		if (request.getTarga() != null)
			mac.setTarga(request.getTarga());
		if (request.getCilindrata() != null)
			mac.setCilindrata(request.getCilindrata());

		motoRepo.save(mac);
	}

	@Override
	public void delete(Integer id) throws Exception {
		Moto moto = motoRepo.findById(id).orElseThrow(() -> new Exception("Moto non trovata"));
		motoRepo.delete(moto);
	}

	@Override
	public List<MotoDTORes> searchByTipoVeicolo(VehicleType tipoVeicolo) throws Exception {
		List<Moto> lM = motoRepo.searchByTipoVeicolo(tipoVeicolo);

		return lM.stream().map(moto -> CostruttoreDTORes.createMotoDTORes(moto)).collect(Collectors.toList());
	}

}
