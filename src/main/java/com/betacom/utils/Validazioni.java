package com.betacom.utils;

import com.betacom.dto.input.MotoDTOReq;

import com.betacom.services.interfaces.InterfaceAlimentazioneService;
import com.betacom.services.interfaces.InterfaceCategoriaService;
import com.betacom.services.interfaces.InterfaceColoreService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Validazioni {
	
	private static InterfaceAlimentazioneService alimentazioneService;
	private static InterfaceCategoriaService categoriaService;
	private static InterfaceColoreService coloreService;
	
	public static boolean validaMoto(MotoDTOReq request) {
		
		return false;
	};

}
