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
import com.betacom.repository.MotoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CostruttoreModels {
	private final CategoriaRepository cateR;
	private final AlimentazioneRepository alimR;
	private final ColoreRepository coloR;
	private final MotoRepository motoRepo;
	
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
					.alimentazione(createAlimentazione(req.getAlimentazione()))
					.categoria(createCategoria(req.getCategoria()))
					.colore(createColore(req.getColore()))
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
				.alimentazione(createAlimentazione(request.getAlimentazione()))
				.categoria(createCategoria(request.getCategoria()))
				.colore(createColore(request.getColore()))
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
	
public Moto validaMotoUpdate(MotoDTOReq request) throws Exception {
	    

	    Moto moto = motoRepo.findById(request.getIdVeicolo())
	                        .orElseThrow(() -> new Exception("Nessuna moto trovata"));

	    
	    if (request.getTipoVeicolo() != null) {
	        moto.setTipoVeicolo(request.getTipoVeicolo());
	    }
	    
	    if (request.getNumeroRuote() != null) {
	        moto.setNumeroRuote(request.getNumeroRuote());
	    }
	    
	    if (request.getAlimentazione() != null) {
	    	Alimentazione alimentazione = createAlimentazione(request.getAlimentazione());
	        moto.setAlimentazione(alimentazione);
	    }
	    
	    if (request.getCategoria() != null) {
	    	Categoria categoria = createCategoria(request.getCategoria());
	        moto.setCategoria(categoria);
	    }
	    
	    if (request.getColore() != null) {
	    	Colore colore = createColore(request.getColore());
	    	
	        moto.setColore(colore);
	    }
	    
	    if (request.getMarca() != null) {
	        moto.setMarca(request.getMarca());
	    }
	    
	    if (request.getAnnoProduzione() != null) {
	        moto.setAnnoProduzione(request.getAnnoProduzione());
	    }
	    
	    if (request.getModello() != null) {
	        moto.setModello(request.getModello());
	    }

	    if (request.getTarga() != null && request.getTarga().length() == 5) {
	        moto.setTarga(request.getTarga());
	    }

	    if (request.getCilindrata() != null) {
	        moto.setCilindrata(request.getCilindrata());
	    }

	    return motoRepo.save(moto);
	}

}
