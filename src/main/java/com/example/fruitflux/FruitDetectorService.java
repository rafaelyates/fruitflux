package com.example.fruitflux;

import java.util.List;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FruitDetectorService {

	public static final String FAKE_FRUIT = "pair";

	public Mono<String> fakeFruitDetector(final List<String> fruits) {
		// fruits.stream().forEach(System.out::println);

		return Flux.fromIterable(fruits).filter(fruit -> fruit == FAKE_FRUIT)
				.doOnNext(fakeFruit -> System.out.println(fakeFruit + " is not a real fruit!")).singleOrEmpty();

	}
}
