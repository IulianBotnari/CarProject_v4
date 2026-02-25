package com.betacom.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.services.interfaces.InterfaceMotoService;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(path = "rest/moto/")
public class MotoController {
	
	private final InterfaceMotoService motoService;
	
	@PostMapping(path = "create")
	public void create(@RequestBody MotoDTOReq request) {
		
		
		
	}
	

}
