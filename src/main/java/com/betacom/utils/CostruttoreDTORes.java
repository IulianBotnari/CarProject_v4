package com.betacom.utils;

import com.betacom.dto.output.BiciclettaDTORes;
import com.betacom.dto.output.MotoDTORes;
import com.betacom.models.Bicicletta;
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
	
}
