package com.betacom;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.alimentazione.AlimentazioneControllerTest;
import com.betacom.categoria.CategoriaControllerTest;
import com.betacom.colore.ColoreControllerTest;
import com.betacom.freno.FrenoControllerTest;

@Suite
@SelectClasses({
	AlimentazioneControllerTest.class,
	ColoreControllerTest.class,
	CategoriaControllerTest.class,
	FrenoControllerTest.class
})

@SpringBootTest
class CarProjectV4ApplicationTests {

	@Test
	void contextLoads() {
	}

}
