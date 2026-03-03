package com.betacom.sospensione;

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

import com.betacom.controller.SospensioneController;
import com.betacom.dto.input.SospensioneDTOReq;
import com.betacom.dto.output.SospensioneDTORes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SospensioneControllerTest {


	@Autowired
	private SospensioneController sospC;
	
	@SuppressWarnings("unchecked")
	@Test
	@Order(1)	
	public void myTest() {
		createSospensione();
		createSospensioneError();
		updateSospensione();
		updateSospensioneError();
		list();
		deleteSospensione();
		deleteSospensioneError();
	}

	public void createSospensione() {
		log.debug("Create Sospensione");
		SospensioneDTOReq req = new SospensioneDTOReq();
		req.setSospensione("Sospensione prova");
		
		ResponseEntity<Object> resp = sospC.create(req);
		assertEquals(HttpStatus.CREATED, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	// capire se serve
	public void createSospensioneError() {
		log.debug("Create Sospensione");
		SospensioneDTOReq req = new SospensioneDTOReq();
		
		ResponseEntity<Object> resp = sospC.create(req);
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void updateSospensione() {
		log.debug("******* Update Sospensione  *******");
		
		SospensioneDTOReq req = new SospensioneDTOReq();
		req.setIdSospensione(1);
		req.setSospensione("Sospensione updated");
		
		ResponseEntity<Object> resp = sospC.update(req);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	public void updateSospensioneError() {
		log.debug("******* Update Sospensione  *******");
		
		SospensioneDTOReq req = new SospensioneDTOReq();
		req.setIdSospensione(99999);
		req.setSospensione("Sospensione updated");
		
		ResponseEntity<Object> resp = sospC.update(req);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void list() {
		log.debug("Test list Sospensione");
		
		ResponseEntity<Object> resp = sospC.listAll();
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Object body = resp.getBody();
		
		List<SospensioneDTORes> lS =  (List<SospensioneDTORes>) body;
		
		Assertions.assertThat(lS.size()).isGreaterThan(0);
		Assertions.assertThat(lS.get(0).getSospensione()).isEqualTo("SOSPENSIONE UPDATED");
		lS.forEach(s -> log.debug(s.toString()));
	}

	public void deleteSospensione() {
		log.debug("******* delete Sospensione  *******");
		
		ResponseEntity<Object> resp = sospC.delete(1);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione completata");
	}
	
	public void deleteSospensioneError() {
		log.debug("******* delete Sospensione  *******");
		
		ResponseEntity<Object> resp = sospC.delete(9999999);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione non riuscita");
	}

}
