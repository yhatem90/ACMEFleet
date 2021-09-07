package com.vehicle;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = VehicleControllerTest.class)
@Import(VehicleControllerTest.class)
@RunWith(SpringRunner.class)
class ACMEApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(ACMEApplicationTests.class);

	@Autowired
	private MockMvc mvc;

	@MockBean
	private VehicleControllerTest arrivalController;

	private VehicleRepositoryTest repository;

	@Autowired
	private ObjectMapper objectMapper;

//	@Test
//	@DisplayName("Single test successful")
//	void contextLoads() {
//		log.info("Success");
//		Vehicle v = new Vehicle("12VTY32", "HONDA", "CRV", 0, 0, false, false, 0, "CAR");
//		VehicleControllerTest test = new VehicleControllerTest(repository);		 
//		test.newVehicle(v);
//		
//	}

//	@Test
//	void whenValidInput_thenReturns200() throws Exception {
//		log.info("Second test");
//		Vehicle v = new Vehicle("12VTY32", "HONDA", "CRV", 0, 0, false, false, 0, "CAR");
//
//		
//		mvc.perform(post("/v1/vehicles").contentType("application/json").content(objectMapper.writeValueAsString(v)))
//				.andExpect(status().isOk());
//	}

}
