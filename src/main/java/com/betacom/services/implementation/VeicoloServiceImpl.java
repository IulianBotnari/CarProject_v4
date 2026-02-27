package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.VeicoloDTOReq;
import com.betacom.dto.output.BiciclettaDTORes;
import com.betacom.dto.output.MacchinaDTORes;
import com.betacom.dto.output.MotoDTORes;
import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.enums.VehicleType;
import com.betacom.models.Bicicletta;
import com.betacom.models.Macchina;
import com.betacom.models.Moto;
import com.betacom.models.Veicolo;
import com.betacom.repository.VeicoloRepository;
import com.betacom.services.interfaces.InterfaceVeicoloService;
import com.betacom.utils.CostruttoreModels;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class VeicoloServiceImpl implements InterfaceVeicoloService{
	
	private final VeicoloRepository veicoloRepo;
	private final CostruttoreModels models;

	@Override
	public List<VeicoloDTORes> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(VeicoloDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(VeicoloDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(VeicoloDTOReq request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<? extends VeicoloDTORes> multiFilter(Integer idVeicolo,                
	        String marca,
	        String modello,
	        VehicleType tipoVeicolo,
	        Integer idAlimentazione,
	        Integer idCategoria,
	        Integer annoProduzione,
	        Integer idColore,
	        Integer numeroRuote,
	        String targa) throws Exception {
	    
	    List<? extends Veicolo> veicoliFiltrati = veicoloRepo.multiFilter(idVeicolo, marca, modello, tipoVeicolo, idAlimentazione, idCategoria, annoProduzione, idColore, numeroRuote,targa);
	    /*

	    return veicoliFiltrati.stream().map(veic -> VeicoloDTORes.builder()
	            .idVeicolo(veic.getIdVeicolo())
	            .marca(veic.getMarca())
	            .modello(veic.getModello())
	            .tipoVeicolo(veic.getTipoVeicolo())
	            .alimentazione(veic.getAlimentazione())
	            .categoria(veic.getCategoria())
	            .numeroRuote(veic.getNumeroRuote())
	            .colore(veic.getColore())
	            .annoProduzione(veic.getAnnoProduzione())
	            
	            .build()).collect(Collectors.toList());
	}
	*/
	    	return veicoliFiltrati.stream().map(veic -> {
	    		if (veic instanceof Macchina mac) {
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
	    		} else if (veic instanceof Moto moto) {
	    			return MotoDTORes.builder()
	    					.idVeicolo(moto.getIdVeicolo())
	    		            .marca(moto.getMarca())
	    		            .modello(moto.getModello())
	    		            .tipoVeicolo(moto.getTipoVeicolo())
	    		            .alimentazione(moto.getAlimentazione())
	    		            .categoria(moto.getCategoria())
	    		            .numeroRuote(moto.getNumeroRuote())
	    		            .colore(moto.getColore())
	    		            .annoProduzione(moto.getAnnoProduzione())
	    		            .targa(moto.getTarga())
	    		            .cilindrata(moto.getCilindrata())
	    		            .build();
	    		} else if (veic instanceof Bicicletta bici){
	    			return BiciclettaDTORes.builder()
	    					.idVeicolo(bici.getIdVeicolo())
	    		            .marca(bici.getMarca())
	    		            .modello(bici.getModello())
	    		            .tipoVeicolo(bici.getTipoVeicolo())
	    		            .alimentazione(bici.getAlimentazione())
	    		            .categoria(bici.getCategoria())
	    		            .numeroRuote(bici.getNumeroRuote())
	    		            .colore(bici.getColore())
	    		            .annoProduzione(bici.getAnnoProduzione())
	    		            .freno(bici.getFreno())
	    		            .numeroMarce(bici.getNumeroMarce())
	    		            .sospensione(bici.getSospensione())
	    		            .build();
	    		}
				return null;
	    	}).collect(Collectors.toList());



}}
