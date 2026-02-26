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

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.input.SospensioneDTOReq;
import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.services.interfaces.InterfaceMotoService;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(path = "rest/moto/")
public class MotoController {
	
	private final InterfaceMotoService motoService;
	
	@PostMapping(path = "create")
	public ResponseEntity<Object> create(@RequestBody MotoDTOReq request) {
		
		Object response = null;
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			
			System.out.println("Try catch moto create");
			motoService.create(request);
			response = "Moto salvata con succeso";
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			response = "Errore durnate il salvataggio della moto";
		}
		
		return ResponseEntity.status(status).body(response);
		
	}
	
	@GetMapping(path = "listAll")	
	public ResponseEntity<Object> listAll(){
		
		HttpStatus status = HttpStatus.OK;
		Object response = null;
		try {
		 response = motoService.list();
		} catch (Exception e) {
			response = "Errore durante il recupero della lista";
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(response);
		
		
	}
	
	
	@PutMapping(path = "update")
	public ResponseEntity<Object> update(@RequestBody(required = true) MotoDTOReq request){
		Object response = null;
		
	//	System.out.println("Mto contr" +(VeicoloDTOReq) request);
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			System.out.println(request.toString());
			motoService.update(request);
			response = "Salvataggio completato";
		} catch (Exception e) {
			response = "Salvataggio non riuscito";
			status = HttpStatus.BAD_REQUEST;
			e.printStackTrace();
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
	
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Object> create(@RequestParam(required = true) Integer id){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {

			motoService.delete(id);
			response = "Eliminazione completata";
		} catch (Exception e) {
			response = "Eliminazione non riuscita";
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
	

}
