package com.betacom.utils;

import com.betacom.dto.input.BiciclettaDTOReq;
import com.betacom.dto.input.MacchinaDTOReq;
import com.betacom.dto.input.MotoDTOReq;
import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.models.Alimentazione;
import com.betacom.models.Bicicletta;
import com.betacom.models.Categoria;
import com.betacom.models.Colore;
import com.betacom.models.Macchina;
import com.betacom.models.Moto;
import com.betacom.models.Veicolo;

public class CostruttoreModels {
	
	public static Bicicletta createBici(BiciclettaDTOReq req) {
		Bicicletta bici = (Bicicletta) createVeicolo(req);
		bici.setNumeroMarce(req.getNumeroMarce());
		return bici;
	}
	
	public static Macchina createMacchina(MacchinaDTOReq req) {
		Macchina mac = (Macchina) createVeicolo(req);
		mac.setPorte(req.getPorte());
		mac.setTarga(req.getTarga());
		mac.setCilindrata(req.getCilindrata());
		return mac;
	}
	
	public static Moto createMoto(MotoDTOReq req) {
		Moto moto = (Moto) createVeicolo(req);
		moto.setTarga(req.getTarga());
		moto.setCilindrata(req.getCilindrata());
		return moto;
	}
	
	private static Veicolo createVeicolo(VeicoloDTOReq request) {
		return Veicolo.builder()
				.idVeicolo(request.getIdVeicolo())
				.annoProduzione(request.getAnnoProduzione())
				.alimentazione(createAlimentazione(request.getAlimentazione()))
				.categoria(createCategoria(request.getCategoria()))
				.colore(createColore(request.getColore()))
				.marca(request.getMarca())
				.numeroRuote(request.getNumeroRuote())
				.modello(request.getModello())
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
