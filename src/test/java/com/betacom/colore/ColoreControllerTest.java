package com.betacom.colore;

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

import com.betacom.controller.ColoreController;
import com.betacom.dto.input.ColoreDTOReq;
import com.betacom.dto.output.ColoreDTORes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ColoreControllerTest {
	
	@Autowired
	private ColoreController coloreC;
	
	@SuppressWarnings("unchecked")
	@Test
	@Order(1)	
	public void myTest() {
		createColore();
		createColoreError();
		updateColore();
		updateColoreError();
		list();
		deleteColore();
		
	}

	public void createColore() {
		log.debug("Create Colore");
		ColoreDTOReq req = new ColoreDTOReq();
		req.setColore("Colore prova");
		
		ResponseEntity<Object> resp = coloreC.create(req);
		assertEquals(HttpStatus.CREATED, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	// capire se serve
	public void createColoreError() {
		log.debug("Create Colore");
		ColoreDTOReq req = new ColoreDTOReq();
		
		ResponseEntity<Object> resp = coloreC.create(req);
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void updateColore() {
		log.debug("******* Update Colore  *******");
		
		ColoreDTOReq req = new ColoreDTOReq();
		req.setIdColore(1);
		req.setColore("Colore updated");
		
		ResponseEntity<Object> resp = coloreC.update(req);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	public void updateColoreError() {
		log.debug("******* Update Colore  *******");
		
		ColoreDTOReq req = new ColoreDTOReq();
		req.setIdColore(99999);
		req.setColore("Colore updated");
		
		ResponseEntity<Object> resp = coloreC.update(req);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	// non so perchè la descrizione diventa uppercase
	public void list() {
		log.debug("Test list Colore");
		
		ResponseEntity<Object> resp = coloreC.listAll();
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Object body = resp.getBody();
		
		List<ColoreDTORes> lS =  (List<ColoreDTORes>) body;
		
		Assertions.assertThat(lS.size()).isGreaterThan(0);
		Assertions.assertThat(lS.get(0).getColore()).isEqualTo("COLORE UPDATED");
		lS.forEach(s -> log.debug(s.toString()));
	}

	public void deleteColore() {
		log.debug("******* delete Colore  *******");
		
		ResponseEntity<Object> resp = coloreC.delete(1);
	
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione completata");
	}

	public void deleteColoreError() {
		log.debug("******* delete Colore  *******");
		
		ResponseEntity<Object> resp = coloreC.delete(999999);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione non riuscita");
	}

}
