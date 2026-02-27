package com.betacom.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.dto.output.VeicoloDTORes;
import com.betacom.enums.VehicleType;
import com.betacom.models.Bicicletta;
import com.betacom.models.Macchina;
import com.betacom.models.Moto;
import com.betacom.models.Veicolo;
import com.betacom.repository.VeicoloRepository;
import com.betacom.services.interfaces.InterfaceVeicoloService;
import com.betacom.utils.CostruttoreDTORes;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class VeicoloServiceImpl implements InterfaceVeicoloService{
	
	private final VeicoloRepository veicoloRepo;

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
	    return veicoliFiltrati.stream().map(veic -> {
	    		if (veic instanceof Macchina mac) {
	    			return CostruttoreDTORes.createMacchinaaDTORes(mac);
	    		} else if (veic instanceof Moto moto) {
	    			return CostruttoreDTORes.createMotoDTORes(moto);
	    		} else if (veic instanceof Bicicletta bici){
	    			return CostruttoreDTORes.createBiciclettaDTORes(bici);
	    		}
				return null;
	    	}).collect(Collectors.toList());

		}
}
