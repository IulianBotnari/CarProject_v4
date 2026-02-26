package com.betacom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.AlimentazioneDTOReq;
import com.betacom.services.interfaces.InterfaceAlimentazioneService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "rest/alimentazione/")
public class AlimentazioneController {
	
	private final InterfaceAlimentazioneService alimS;
	
	@PostMapping(path = "create")
	public ResponseEntity<Object> create(@RequestBody AlimentazioneDTOReq request) {
		
		Object response = null;
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			alimS.create(request);
			response = "Alimentzione salvata con succeso";
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			response = "Errore durnate il salvataggio della alimentazione";
		}
		
		return ResponseEntity.status(status).body(response);
	}
	
	@GetMapping(path = "listAll")	
	public ResponseEntity<Object> listAll(){
		
		HttpStatus status = HttpStatus.OK;
		Object response = null;
		try {
		 response = alimS.list();
		} catch (Exception e) {
			response = "Errore durante il recupero della lista";
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(response);
	}
	
	
	@PutMapping(path = "update")
	public ResponseEntity<Object> update(@RequestBody(required = true) AlimentazioneDTOReq request){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			System.out.println(request.toString());
			alimS.update(request);
			response = "Salvataggio completato";
		} catch (Exception e) {
			response = "Salvataggio non riuscito";
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(response);
	}
	
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Object> delete(@RequestParam(required = true) Integer id){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			alimS.delete(id);
			response = "Eliminazione completata";
		} catch (Exception e) {
			response = "Eliminazione non riuscita";
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(response);
	}
	
	

}
