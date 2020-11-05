package com.github.parmag.examples.fixefidjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.parmag.examples.fixefidjpa.domain.Customer;
import com.github.parmag.examples.fixefidjpa.repo.CustomerRepository;
import com.github.parmag.fixefid.record.BeanRecord;

@SpringBootApplication
public class FixefidjpaApplication {
	private static final Logger LOG = LoggerFactory.getLogger(FixefidjpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FixefidjpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(CustomerRepository repository) {
		return args -> {
			// create all customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			LOG.info("Customers found with findAll():");
			LOG.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				LOG.info(customer.toString());
				LOG.info("Customer Record=[" + new BeanRecord(customer).toString() + "]");
			});
			LOG.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			LOG.info("Customer found with findById(1L):");
			LOG.info("--------------------------------");
			LOG.info(customer.toString());
			LOG.info("Customer Record=[" + new BeanRecord(customer).toString() + "]");
			LOG.info("");

			// fetch customers by last name
			LOG.info("Customer found with findByLastName('Bauer'):");
			LOG.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				LOG.info(bauer.toString());
				LOG.info("Bauer Record=[" + new BeanRecord(bauer).toString() + "]");
			});
			LOG.info("");
			
			// create a new customer from record as string, save and fetch
			LOG.info("Create new Customer from Record=[0000000000000000000Paul                                              Parma                                             ]");
			String parmaRecordAsString = "0000000000000000000Paul                                              Parma                                             ";
			Customer parmaCustomer = new Customer(null, null);
			new BeanRecord(parmaCustomer, parmaRecordAsString);
			repository.save(parmaCustomer);
			LOG.info("Customer found with findByLastName('Parma'):");
			LOG.info("--------------------------------------------");
			repository.findByLastName("Parma").forEach(parma -> {
				LOG.info(parma.toString());
			});
			LOG.info("");
		};
	}

}
