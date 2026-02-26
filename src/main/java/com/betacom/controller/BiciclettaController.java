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

import com.betacom.dto.input.BiciclettaDTOReq;
import com.betacom.services.interfaces.InterfaceBiciclettaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "rest/bicicletta/")
public class BiciclettaController {
	
	private final InterfaceBiciclettaService biciService;
	
	@PostMapping(path = "create")
	public ResponseEntity<Object> create(@RequestBody(required = true) BiciclettaDTOReq request){
		System.out.println("entra nel metodo");
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			System.out.println("Try catch bicicletta create");
			biciService.create(request);
			response = "Bicicletta salvata con succeso";
		} catch (Exception e) {
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
			response = "Errore durnate il salvataggio della bicicletta";
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
	
	@GetMapping(path = "list_all")	
	public ResponseEntity<Object> listAll(){
		
		HttpStatus status = HttpStatus.OK;
		Object response = null;
		try {
		 response = biciService.list();
		} catch (Exception e) {
			response = "Errore durante il recupero della lista";
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(response);
		
		
	}
	
	@PutMapping(path = "update")
	public ResponseEntity<Object> update(@RequestBody(required = true) BiciclettaDTOReq request){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			System.out.println(request.toString());
			biciService.update(request);
			response = "Aggiornamento completato";
		} catch (Exception e) {
			response = "Aggiornamento non riuscito";
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Object> create(@RequestParam(required = true) Integer id){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {

			biciService.delete(id);
			response = "Eliminazione completata";
		} catch (Exception e) {
			response = "Eliminazione non riuscita";
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
}
