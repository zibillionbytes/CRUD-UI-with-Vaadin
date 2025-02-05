package com.test.CRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	private static final Logger log = LoggerFactory.getLogger(CrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(CustomerRepository repository) {
		return (args) -> {

			repository.save(new Customer("Kerim", "Tekin"));
			repository.save(new Customer("Barış", "Manço"));
			repository.save(new Customer("Sertab", "Erener"));
			repository.save(new Customer("Harun", "Tekin"));
			repository.save(new Customer("Rasim", "Öztekin"));
			repository.save(new Customer("Özlem", "Tekin"));
			repository.save(new Customer("Cem", "Yılmaz"));


			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");


			Customer customer = repository.findById(5L).get();
			log.info("Customer found with findOne(5L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");


			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Tekin'):");
			log.info("--------------------------------------------");
			for (Customer tekin : repository
					.findByLastNameStartsWithIgnoreCase("Tekin")) {
				log.info(tekin.toString());
			}
			log.info("");
		};
	}


}
