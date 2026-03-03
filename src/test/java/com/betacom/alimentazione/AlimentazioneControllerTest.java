package com.betacom.alimentazione;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.betacom.controller.AlimentazioneController;
import com.betacom.dto.input.AlimentazioneDTOReq;
import com.betacom.dto.output.AlimentazioneDTORes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlimentazioneControllerTest {
	
	@Autowired
	private AlimentazioneController alimC;
	

	@SuppressWarnings("unchecked")
	@Test
	@Order(1)	
	public void myTest() {
		createAlimentazione();
		createAlimentazioneError();
		updateAlimentazione();
		updateAlimentazioneError();
		list();
		deleteAlimentazione();
		deleteAlimentazioneError();
	}

	public void createAlimentazione() {
		log.debug("Create Alimentazione");
		AlimentazioneDTOReq req = new AlimentazioneDTOReq();
		req.setAlimentazione("Alimentazione prova");
		
		ResponseEntity<Object> resp = alimC.create(req);
		assertEquals(HttpStatus.CREATED, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Alimentzione salvata con succeso");
	}

	// capire se serve
	public void createAlimentazioneError() {
		log.debug("Create Alimentazione");
		AlimentazioneDTOReq req = new AlimentazioneDTOReq();
		
		ResponseEntity<Object> resp = alimC.create(req);
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Errore durnate il salvataggio della alimentazione");
	}
	
	public void updateAlimentazione() {
		log.debug("******* Update alimentazione  *******");
		
		AlimentazioneDTOReq req = new AlimentazioneDTOReq();
		req.setIdAlimentazione(1);
		req.setAlimentazione("Alimentazione updated");
		
		ResponseEntity<Object> resp = alimC.update(req);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	public void updateAlimentazioneError() {
		log.debug("******* Update alimentazione  *******");
		
		AlimentazioneDTOReq req = new AlimentazioneDTOReq();
		req.setIdAlimentazione(99999);
		req.setAlimentazione("Alimentazione updated");
		
		ResponseEntity<Object> resp = alimC.update(req);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void list() {
		log.debug("Test list alimentazione");
		
		ResponseEntity<Object> resp = alimC.listAll();
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Object body = resp.getBody();
		
		List<AlimentazioneDTORes> lS =  (List<AlimentazioneDTORes>) body;
		
		Assertions.assertThat(lS.size()).isGreaterThan(0);
		Assertions.assertThat(lS.get(0).getAlimentazione()).isEqualTo("Alimentazione updated");
		lS.forEach(s -> log.debug(s.toString()));
	}

	public void deleteAlimentazione() {
		log.debug("******* delete alimentazione  *******");
		
		ResponseEntity<Object> resp = alimC.delete(1);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione completata");
	}

	public void deleteAlimentazioneError() {
		log.debug("******* delete alimentazione  *******");
		
		ResponseEntity<Object> resp = alimC.delete(9999999);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione non riuscita");
	}

}
