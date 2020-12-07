package com.example.fruitflux;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.test.StepVerifier;

@SpringBootTest
public class FruitDetectorServiceTest {

	@Test
	public void fakeFruitDetectorWithValidValuesTest() {
		final var validFruits = List.of("apple", "pear");
		final var detector = new FruitDetectorService();

		StepVerifier.create(detector.fakeFruitDetector(validFruits)).verifyComplete();

	}

	@Test
	public void fakeFruitDetectorWithInvalidValuesTest() {
		final var invalidFruits = List.of("apple", FruitDetectorService.FAKE_FRUIT);
		final var detector = new FruitDetectorService();

		StepVerifier.create(detector.fakeFruitDetector(invalidFruits)).expectNext(FruitDetectorService.FAKE_FRUIT)
				.verifyComplete();
	}

}
