package com.betacom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.enums.VehicleType;
import com.betacom.services.interfaces.InterfaceBiciclettaService;
import com.betacom.services.interfaces.InterfaceMacchinaService;
import com.betacom.services.interfaces.InterfaceMotoService;
import com.betacom.services.interfaces.InterfaceVeicoloService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "rest/veicolo/")
public class VeicoloController {

	private final InterfaceMacchinaService macchinaS;
	private final InterfaceMotoService motoS;
	private final InterfaceBiciclettaService biciS;
	private final InterfaceVeicoloService veicoloS;
/*
	@GetMapping(path = "listByVeicoloType")
	public ResponseEntity<Object> listByVeicoloType(@RequestParam(required = false) VehicleType tipoVeicolo) {

		HttpStatus status = HttpStatus.OK;
		Object response = null;

		try {
			switch (tipoVeicolo) {
			case MACCHINA:
				response = macchinaS.searchByTipoVeicolo(tipoVeicolo);
				break;
			case MOTO:
				response = motoS.searchByTipoVeicolo(tipoVeicolo);
				break;
			case BICICLETTA:
				response = biciS.searchByTipoVeicolo(tipoVeicolo);
				break;
			default:
					response = "Veicolo non classificato";
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = "Errore durante il recupero della lista";
			status = HttpStatus.BAD_REQUEST;
		}

		return ResponseEntity.status(status).body(response);

	}*/
	
	
	@GetMapping(path = "multiFilter/{idVeicolo}/{tipoVeicolo}/{numeroRuote}/{idAlimentazione}/{idCategoria}/{idColore}/{marca}/{annoProduzione}/{modello}")
	public ResponseEntity<Object> multiFilterVeicolo(@RequestParam(required = false) Integer idVeicolo,
			@RequestParam(required = false) VehicleType tipoVeicolo,
			@RequestParam(required = false) Integer numerRuote,
			@RequestParam(required = false) Integer idAlimentazione,
			@RequestParam(required = false) Integer idCategoria,
			@RequestParam(required = false) Integer idColore,
			@RequestParam(required = false) String marca,
			@RequestParam(required = false) Integer annoProduzione,
			@RequestParam(required = false) String modello) {
		
		Object response = null;
		HttpStatus status = HttpStatus.OK;
		
		try {
			response = veicoloS.multiFilter(idVeicolo, marca, modello, tipoVeicolo, idAlimentazione, idCategoria, annoProduzione, idColore, annoProduzione);
		} catch (Exception e) {
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
			response = "Impossibile recuperare il veicolo";
		}
		
		return ResponseEntity.status(status).body(response);
	}

}
