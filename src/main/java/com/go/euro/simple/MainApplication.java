package com.go.euro.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.go.euro.simple.domain.CityReader;
import com.go.euro.simple.service.CityService;

/**
 * @author Ricardo Bonaldo
 * Main Class. When called must find all the ocurrences based on the searched word and generate a CSF File
 */
@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	@Autowired
	private CityService cityService;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) {
		for (String city : args) {
			CityReader[] cities = this.cityService.getCities(city);
			this.cityService.writeCsvFile(cities, city);
		}
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplication.class, args);
	}
}
