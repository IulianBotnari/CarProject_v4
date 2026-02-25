package com.betacom.utils;

import org.springframework.stereotype.Component;

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
import com.betacom.repository.AlimentazioneRepository;
import com.betacom.repository.CategoriaRepository;
import com.betacom.repository.ColoreRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CostruttoreModels {
	private final CategoriaRepository cateR;
	private final AlimentazioneRepository alimR;
	private final ColoreRepository coloR;
	
	public Bicicletta createBici(BiciclettaDTOReq req) throws Exception {
		Bicicletta bici = (Bicicletta) createVeicolo(req);
		bici.setNumeroMarce(req.getNumeroMarce());
		return bici;
	}
	
	public Macchina createMacchina(MacchinaDTOReq req) throws Exception {
		Macchina mac = (Macchina) createVeicolo(req);
		mac.setPorte(req.getPorte());
		mac.setTarga(req.getTarga());
		mac.setCilindrata(req.getCilindrata());
		return mac;
	}
	
	public Moto createMoto(MotoDTOReq req) throws Exception {
		System.out.println("costruttore models moto");

			/*Moto moto = (Moto) createVeicolo(req);
			moto.setTarga(req.getTarga());
			moto.setCilindrata(req.getCilindrata());*/
			return Moto.builder()
					.idVeicolo(null)
					.annoProduzione(req.getAnnoProduzione())
					.alimentazione(createAlimentazione(req.getIdAlimentazione()))
					.categoria(createCategoria(req.getIdCategoria()))
					.colore(createColore(req.getIdColore()))
					.marca(req.getMarca())
					.numeroRuote(req.getNumeroRuote())
					.modello(req.getModello())
					.tipoVeicolo(req.getTipoVeicolo())
					.targa(req.getTarga())
					.cilindrata(req.getCilindrata())
					.build();


	}
	
	private Veicolo createVeicolo(VeicoloDTOReq request) throws Exception {
		return Veicolo.builder()
				.idVeicolo(request.getIdVeicolo())
				.annoProduzione(request.getAnnoProduzione())
				.alimentazione(createAlimentazione(request.getIdAlimentazione()))
				.categoria(createCategoria(request.getIdCategoria()))
				.colore(createColore(request.getIdColore()))
				.marca(request.getMarca())
				.numeroRuote(request.getNumeroRuote())
				.modello(request.getModello())
				.tipoVeicolo(request.getTipoVeicolo())
				.build();
	}
	
	private Categoria createCategoria(Integer idCategoria) throws Exception {
		Categoria cat = cateR.findById(idCategoria).orElseThrow(() -> new Exception("Categoria non trovata"));
		
		return Categoria.builder().idCategoria(idCategoria).categoria(cat.getCategoria()).build();
	}
	
	private Alimentazione createAlimentazione(Integer idAlimentazione) throws Exception {
		Alimentazione alim = alimR.findById(idAlimentazione).orElseThrow(() -> new Exception("Alimentazione non trovata"));

		return Alimentazione.builder().idAlimentazione(idAlimentazione).alimentazione(alim.getAlimentazione()).build();
	}
	
	private Colore createColore(Integer idColore) throws Exception {
		Colore colore = coloR.findById(idColore).orElseThrow(() -> new Exception("Colore non trovato"));
		
		return Colore.builder().idColore(idColore).colore(colore.getColore()).build();
	}

}
