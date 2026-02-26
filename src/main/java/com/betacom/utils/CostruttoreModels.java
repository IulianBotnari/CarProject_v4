package com.betacom.utils;

import org.springframework.stereotype.Component;

import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.models.Alimentazione;

import com.betacom.models.Categoria;
import com.betacom.models.Colore;
import com.betacom.models.Freno;
import com.betacom.models.Sospensione;
import com.betacom.models.Veicolo;
import com.betacom.repository.AlimentazioneRepository;
import com.betacom.repository.CategoriaRepository;
import com.betacom.repository.ColoreRepository;
import com.betacom.repository.FrenoRepository;
import com.betacom.repository.MotoRepository;
import com.betacom.repository.SospensioneRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CostruttoreModels {
	private final CategoriaRepository cateR;
	private final AlimentazioneRepository alimR;
	private final ColoreRepository coloR;
	private final MotoRepository motoRepo;
	private final SospensioneRepository sospRepo;
	private final FrenoRepository frenoRepo;
	
	public void updateVeicolo(Veicolo dbVeicolo, VeicoloDTOReq v) throws Exception {

	    if (v.getAnnoProduzione() != null)
	        dbVeicolo.setAnnoProduzione(v.getAnnoProduzione());

	    if (v.getMarca() != null)
	        dbVeicolo.setMarca(v.getMarca());

	    if (v.getModello() != null)
	        dbVeicolo.setModello(v.getModello());

	    if (v.getNumeroRuote() != null)
	        dbVeicolo.setNumeroRuote(v.getNumeroRuote());

	    if (v.getTipoVeicolo() != null)
	        dbVeicolo.setTipoVeicolo(v.getTipoVeicolo());

	    if (v.getAlimentazione() != null)
	        dbVeicolo.setAlimentazione(createAlimentazione(v.getAlimentazione()));

	    if (v.getCategoria() != null)
	        dbVeicolo.setCategoria(createCategoria(v.getCategoria()));

	    if (v.getColore() != null)
	        dbVeicolo.setColore(createColore(v.getColore()));
	    
	}
	


	public void populateVeicolo(Veicolo v, VeicoloDTOReq request) throws Exception {
	    v.setIdVeicolo(request.getIdVeicolo());
	    v.setAnnoProduzione(request.getAnnoProduzione());
	    v.setAlimentazione(createAlimentazione(request.getAlimentazione()));
	    v.setCategoria(createCategoria(request.getCategoria()));
	    v.setColore(createColore(request.getColore()));
	    v.setMarca(request.getMarca());
	    v.setNumeroRuote(request.getNumeroRuote());
	    v.setModello(request.getModello());
	    v.setTipoVeicolo(request.getTipoVeicolo());
	}
	

	
	private Categoria createCategoria(Integer idCategoria) throws Exception {
		Categoria cat = cateR.findById(idCategoria).orElseThrow(() -> new Exception("Categoria non trovata"));
		
		return Categoria.builder().idCategoria(idCategoria).categoria(cat.getCategoria()).build();
	}
	
	private Alimentazione createAlimentazione(Integer idAlimentazione) throws Exception {
		Alimentazione alim = alimR.findById(idAlimentazione).orElseThrow(() -> new Exception("Alimentazione non trovata"));

		return Alimentazione.builder().idAlimentazione(idAlimentazione).alimentazione(alim.getAlimentazione()).build();
	}
	
	public Sospensione createSospensione(Integer idSospensione) throws Exception {
		Sospensione sosp = sospRepo.findById(idSospensione).orElseThrow(() -> new Exception("Sospensione non trovata"));
		
		return Sospensione.builder().idSospensione(idSospensione).sospensione(sosp.getSospensione()).build();
	}

	public Freno createFreno(Integer idFreno) throws Exception {
		Freno freno = frenoRepo.findById(idFreno).orElseThrow(() -> new Exception("Freno non trovato"));
		
		return Freno.builder().idFreno(idFreno).freno(freno.getFreno()).build();
	}
	
	private Colore createColore(Integer idColore) throws Exception {
		Colore colore = coloR.findById(idColore).orElseThrow(() -> new Exception("Colore non trovato"));
		
		return Colore.builder().idColore(idColore).colore(colore.getColore()).build();
	}
}
