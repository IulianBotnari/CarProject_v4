package com.betacom;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.alimentazione.AlimentazioneControllerTest;
import com.betacom.colore.ColoreControllerTest;

@Suite
@SelectClasses({
	AlimentazioneControllerTest.class,
	ColoreControllerTest.class
})

@SpringBootTest
class CarProjectV4ApplicationTests {

	@Test
	void contextLoads() {
	}

}
