package com.betacom;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.alimentazione.AlimentazioneControllerTest;

@Suite
@SelectClasses({
	AlimentazioneControllerTest.class
})

@SpringBootTest
class CarProjectV4ApplicationTests {

	@Test
	void contextLoads() {
	}

}
