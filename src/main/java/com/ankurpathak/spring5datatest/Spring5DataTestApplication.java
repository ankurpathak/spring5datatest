package com.ankurpathak.spring5datatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Spring5DataTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5DataTestApplication.class, args);
	}
}


@Component
class Spring5DataTestApplicationCmd implements CommandLineRunner{

	@Autowired
	private INameRepository nameRepository;


	@Override
	public void run(String... args) throws Exception {
		nameRepository.save(new Name("Ankur", "Pathak"));

		nameRepository.save(new Name("Ashish", "Nipane"));

		System.out.println(nameRepository.findByFirstName("Ankur").stream().findFirst().orElse(null));

		System.out.println(nameRepository.findByFirstName("Ashish").stream().findFirst().orElse(null));


	}
}