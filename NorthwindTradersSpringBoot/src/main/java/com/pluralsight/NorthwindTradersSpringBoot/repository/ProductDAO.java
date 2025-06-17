package com.pluralsight.NorthwindTradersSpringBoot.repository;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDAO {

     void add(Product product);

    List<Product> getAll();
}
