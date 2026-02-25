package com.betacom.utils;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.models.Alimentazione;
import com.betacom.models.Categoria;
import com.betacom.models.Colore;
import com.betacom.models.Moto;
import com.betacom.models.Veicolo;

public class CostruttoreModels {
	
	public static Veicolo createVeicolo(VeicoloDTOReq request) {
			
		return Veicolo.builder()
				.idVeicolo(request.getIdVeicolo())
				.annoProduzione(request.getAnnoProduzione())
//				.cilindrata(request.getCilindrata())
				.alimentazione(createAlimentazione(request.getAlimentazione()))
				.categoria(createCategoria(request.getCategoria()))
				.colore(createColore(request.getColore()))
				.marca(request.getMarca())
				.numeroRuote(request.getNumeroRuote())
				.modello(request.getModello())
//				.targa(request.getTarga())
				.tipoVeicolo(request.getTipoVeicolo())
				.build();
		
	}
	
	private static Categoria createCategoria(String categoria) {
		
		return Categoria.builder().idCategoria(0).categoria(categoria).build();
	}
	
	private static Alimentazione createAlimentazione(String alimentazione) {
		
		return Alimentazione.builder().idAlimentazione(0).alimentazione(alimentazione).build();
	}
	
	private static Colore createColore(String colore) {
		return Colore.builder().idColore(0).colore(colore).build();
	}

}
