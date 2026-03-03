package com.betacom.categoria;

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

import com.betacom.controller.CategoriaController;
import com.betacom.dto.input.CategoriaDTOReq;
import com.betacom.dto.output.CategoriaDTORes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaControllerTest {

	@Autowired
	private CategoriaController cateC;
	
	@SuppressWarnings("unchecked")
	@Test
	@Order(1)	
	public void myTest() {
		createCategoria();
		createCategoriaError();
		updateCategoria();
		updateCategoriaError();
		list();
		deleteCategoria();
		deleteCategoriaError();
	}

	public void createCategoria() {
		log.debug("Create Categoria");
		CategoriaDTOReq req = new CategoriaDTOReq();
		req.setCategoria("Categoria prova");
		
		ResponseEntity<Object> resp = cateC.create(req);
		assertEquals(HttpStatus.CREATED, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	// capire se serve
	public void createCategoriaError() {
		log.debug("Create Categoria");
		CategoriaDTOReq req = new CategoriaDTOReq();
		
		ResponseEntity<Object> resp = cateC.create(req);
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void updateCategoria() {
		log.debug("******* Update Categoria  *******");
		
		CategoriaDTOReq req = new CategoriaDTOReq();
		req.setIdCategoria(1);
		req.setCategoria("Categoria updated");
		
		ResponseEntity<Object> resp = cateC.update(req);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio completato");
	}

	public void updateCategoriaError() {
		log.debug("******* Update Categoria  *******");
		
		CategoriaDTOReq req = new CategoriaDTOReq();
		req.setIdCategoria(99999);
		req.setCategoria("Categoria updated");
		
		ResponseEntity<Object> resp = cateC.update(req);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		Assertions.assertThat(resp.getBody()).isEqualTo("Salvataggio non riuscito");
	}
	
	public void list() {
		log.debug("Test list Categoria");
		
		ResponseEntity<Object> resp = cateC.listAll();
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		Object body = resp.getBody();
		
		List<CategoriaDTORes> lS =  (List<CategoriaDTORes>) body;
		
		Assertions.assertThat(lS.size()).isGreaterThan(0);
		Assertions.assertThat(lS.get(0).getCategoria()).isEqualTo("Categoria updated");
		lS.forEach(s -> log.debug(s.toString()));
	}

	public void deleteCategoria() {
		log.debug("******* delete Categoria  *******");
		
		ResponseEntity<Object> resp = cateC.delete(1);
		
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione completata");
	}
	public void deleteCategoriaError() {
		log.debug("******* delete Categoria  *******");
		
		ResponseEntity<Object> resp = cateC.delete(9999999);
		
		assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
		String r = (String) resp.getBody();
		log.debug(r);
		Assertions.assertThat(r).isEqualTo("Eliminazione non riuscita");
	}
}
