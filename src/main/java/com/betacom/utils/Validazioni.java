package com.betacom.utils;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import com.betacom.dto.input.MotoDTOReq;
import com.betacom.models.Moto;
import com.betacom.repository.MotoRepository;
import com.betacom.services.interfaces.InterfaceAlimentazioneService;
import com.betacom.services.interfaces.InterfaceCategoriaService;
import com.betacom.services.interfaces.InterfaceColoreService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;



@Component
@AllArgsConstructor
public class Validazioni {
	
	private static InterfaceAlimentazioneService alimentazioneService;
	private static InterfaceCategoriaService categoriaService;
	private static InterfaceColoreService coloreService;
	
	/*
	private MotoRepository motoRepo;
	
	public Moto validaMoto(Object request) throws Exception {
	    
	    if (request instanceof MotoDTOReq) {
	        MotoDTOReq motoReq = (MotoDTOReq) request;
	        
	   
	        Moto moto = motoRepo.findById(motoReq.getIdVeicolo())
	                            .orElseThrow(() -> new Exception("Nessuna moto trovata"));
	        
	        Method[] metodiDto = motoReq.getClass().getMethods();
	        
	        for (Method getter : metodiDto) {

	            if (getter.getName().startsWith("get") && !getter.getName().equals("getClass")) {

	                Object valore = getter.invoke(motoReq);
	                
	                if (valore != null) {
	                    
	                    String nomeSetter = getter.getName().replaceFirst("get", "set");
	                    if (nomeSetter.equals("setTarga")) {
	                        continue; 
	                    }
	                    
	                    try {
	                        Method setter = Moto.class.getMethod(nomeSetter, getter.getReturnType());
	                        
	                        setter.invoke(moto, valore);
	                        
	                    } catch (NoSuchMethodException e) {

	                        System.out.println(nomeSetter + " non esiste in Moto");
	                    }
	                }
	            }
	        }
	        return motoRepo.save(moto);
	    }
	    
	    throw new Exception("Tipo richiesta non valido");
	}*/
	
	
	

}
