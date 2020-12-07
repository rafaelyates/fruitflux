package com.example.fruitflux;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FruitsController {

	@Autowired
	private FruitDetectorService detector;

	@PostMapping("/")
	public Mono<String> fruits(@RequestBody List<String> fruits) {
		return detector.fakeFruitDetector(fruits);
	}

}
