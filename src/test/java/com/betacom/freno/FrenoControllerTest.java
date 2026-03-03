package com.betacom.freno;

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

import com.betacom.controller.FrenoController;
import com.betacom.dto.input.FrenoDTOReq;
import com.betacom.dto.output.FrenoDTORes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FrenoControllerTest {


	@Autowired
	private FrenoController frenoC;
	
	@SuppressWarnings("unchecked")
	@Test
	@Order(1)	
	public void myTest() {
		createFreno();
		createFrenoError();
		updateFreno();
		updateFrenoError();
		list();
		deleteFreno();
		deleteFrenoError();
	}

	public void createFreno() {
		log.debug("Create Freno");
		FrenoDTOReq req = new FrenoDTOReq();
		req.setFreno("Freno prova");
		
		ResponseEntity<Object> resp = frenoC.create(req);
		assertEquals(HttpStatus.CREATED, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	// capire se serve
	public void createFrenoError() {
		log.debug("Create Freno");
		FrenoDTOReq req = new FrenoDTOReq();
		
		ResponseEntity<Object> resp = frenoC.create(req);
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void updateFreno() {
		log.debug("******* Update Freno  *******");
		
		FrenoDTOReq req = new FrenoDTOReq();
		req.setIdFreno(1);
		req.setFreno("Freno updated");
		
		ResponseEntity<Object> resp = frenoC.update(req);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	public void updateFrenoError() {
		log.debug("******* Update Freno  *******");
		
		FrenoDTOReq req = new FrenoDTOReq();
		req.setIdFreno(99999);
		req.setFreno("Freno updated");
		
		ResponseEntity<Object> resp = frenoC.update(req);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void list() {
		log.debug("Test list Freno");
		
		ResponseEntity<Object> resp = frenoC.listAll();
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Object body = resp.getBody();
		
		List<FrenoDTORes> lS =  (List<FrenoDTORes>) body;
		
		Assertions.assertThat(lS.size()).isGreaterThan(0);
		Assertions.assertThat(lS.get(0).getFreno()).isEqualTo("Freno updated");
		lS.forEach(s -> log.debug(s.toString()));
	}

	public void deleteFreno() {
		log.debug("******* delete Freno  *******");
		
		ResponseEntity<Object> resp = frenoC.delete(1);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione completata");
	}
	
	public void deleteFrenoError() {
		log.debug("******* delete Freno  *******");
		
		ResponseEntity<Object> resp = frenoC.delete(9999999);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione non riuscita");
	}
}
