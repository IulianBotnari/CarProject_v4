package com.betacom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.SospensioneDTOReq;
import com.betacom.services.interfaces.InterfaceSospensioneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


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
			System.out.println(request.toString());
			sospensioneService.create(request);
			response = "Salvataggio completato";
		} catch (Exception e) {
			response = "Salvataggio non riuscito";
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return ResponseEntity.status(status).body(response);
	}
}
