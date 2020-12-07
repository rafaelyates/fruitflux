package com.example.fruitflux;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@WebFluxTest(FruitsController.class)
@ContextConfiguration(classes = { FruitsController.class, FruitDetectorService.class })
public class FruitsControllerTest {

	@Autowired
	private WebTestClient testClient;

	@Test
	public void testRestApiWithValidValuesTest() {
		testClient.post().uri("/").contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(List.of("apple", "pear"))).exchange().expectStatus().is2xxSuccessful();
	}

	@Test
	public void testRestApiWithInvalidValuesTest() {
		testClient.post().uri("/").contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(List.of("apple", FruitDetectorService.FAKE_FRUIT))).exchange()
				.expectStatus().isOk().expectBody(String.class).isEqualTo(null);
	}

}
