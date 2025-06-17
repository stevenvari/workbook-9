package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Program implements CommandLineRunner {

	@Autowired
	@Qualifier("jdbcProductDAO")
	ProductDAO productDAO;


	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		 productDAO.add(new Product(0, "sprite",2.99));

		List<Product> products = productDAO.getAll();
		System.out.println(products);
	}

	
}
