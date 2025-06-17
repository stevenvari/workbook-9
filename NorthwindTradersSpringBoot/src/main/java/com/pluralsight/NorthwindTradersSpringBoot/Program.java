package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program implements CommandLineRunner {

	@Autowired
	SimpleProductDAO productDAO;


	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}

	
}
