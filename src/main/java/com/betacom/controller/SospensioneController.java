package com.betacom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.SospensioneDTOReq;
import com.betacom.services.interfaces.InterfaceSospensioneService;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "rest/sospensione/")
public class SospensioneController {
	private final InterfaceSospensioneService sospensioneService;
	
	@PostMapping(path = "create")
	public ResponseEntity<Object> create(@RequestBody(required = true) SospensioneDTOReq request){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			sospensioneService.create(request);
			response = "Salvataggio completato";
		} catch (Exception e) {
			response = "Salvataggio non riuscito";
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
	
	
	
	@GetMapping(path = "list_all")	
	public ResponseEntity<Object> listAll(){
		
		HttpStatus status = HttpStatus.OK;
		Object response = null;
		try {
		 response = sospensioneService.list();
		} catch (Exception e) {
			response = "Errore durante il recupero della lista";
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(response);
		
		
	}
	
	
	@PutMapping(path = "update")
	public ResponseEntity<Object> update(@RequestBody(required = true) SospensioneDTOReq request){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			System.out.println(request.toString());
			sospensioneService.update(request);
			response = "Salvataggio completato";
		} catch (Exception e) {
			response = "Salvataggio non riuscito";
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
	
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Object> create(@RequestParam(required = true) Integer id){
		Object response = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {

			sospensioneService.delete(id);
			response = "Eliminazione completata";
		} catch (Exception e) {
			response = "Eliminazione non riuscita";
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
	
	
}
