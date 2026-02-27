package com.betacom.utils;

import com.betacom.dto.output.BiciclettaDTORes;
import com.betacom.dto.output.MacchinaDTORes;
import com.betacom.dto.output.MotoDTORes;
import com.betacom.models.Bicicletta;
import com.betacom.models.Macchina;
import com.betacom.models.Moto;

public class CostruttoreDTORes {
	
	
	public static MotoDTORes createMotoDTORes(Moto moto) {
		
		return MotoDTORes.builder()
				.idVeicolo(moto.getIdVeicolo())
				.alimentazione(moto.getAlimentazione())
				.annoProduzione(moto.getAnnoProduzione())
				.categoria(moto.getCategoria())
				.cilindrata(moto.getCilindrata())
				.colore(moto.getColore())
				.marca(moto.getMarca())
				.modello(moto.getModello())
				.numeroRuote(moto.getNumeroRuote())
				.targa(moto.getTarga())
				.tipoVeicolo(moto.getTipoVeicolo())
				.build();
	}

	public static BiciclettaDTORes createBiciclettaDTORes(Bicicletta bici) {
			
			return BiciclettaDTORes.builder()
					.idVeicolo(bici.getIdVeicolo())
					.alimentazione(bici.getAlimentazione())
					.annoProduzione(bici.getAnnoProduzione())
					.categoria(bici.getCategoria())
					.numeroMarce(bici.getNumeroMarce())
					.colore(bici.getColore())
					.marca(bici.getMarca())
					.modello(bici.getModello())
					.numeroRuote(bici.getNumeroRuote())
					.freno(bici.getFreno())
					.tipoVeicolo(bici.getTipoVeicolo())
					.sospensione(bici.getSospensione())
					.build();
	}
	
	public static MacchinaDTORes createMacchinaaDTORes(Macchina mac) {
		return MacchinaDTORes.builder()
				.idVeicolo(mac.getIdVeicolo())
	            .marca(mac.getMarca())
	            .modello(mac.getModello())
	            .tipoVeicolo(mac.getTipoVeicolo())
	            .alimentazione(mac.getAlimentazione())
	            .categoria(mac.getCategoria())
	            .porte(mac.getPorte())
	            .numeroRuote(mac.getNumeroRuote())
	            .colore(mac.getColore())
	            .annoProduzione(mac.getAnnoProduzione())
	            .targa(mac.getTarga())
	            .cilindrata(mac.getCilindrata())
	            .build();
	}
	
	
	
}
