package com.pluralsight.northwindtraders.api.controller;

import com.pluralsight.northwindtraders.api.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping(path = "/products")
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Laptop", 101, 999.99));
        products.add(new Product(2, "T-Shirt", 102, 19.99));
        products.add(new Product(3, "Coffee Maker", 103, 49.99));
        products.add(new Product(4, "Book: 1984", 104, 14.99));
        products.add(new Product(5, "Basketball", 105, 29.99));

        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        Product product = new Product(id, "laptop", 200, 400);
        return product;

    }
}
