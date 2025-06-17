package com.pluralsight.NorthwindTradersSpringBoot.repository;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class SimpleProductDAO implements ProductDAO {

    private List<Product> products;

    private int nexId = 1;

    public SimpleProductDAO() {

        products = new ArrayList<>();

        products.add(new Product(nexId++, "cookies", "cosco", 15.5));
        products.add(new Product(nexId++,"coke", "fritolay", 20));
    }

    @Override
    public void add(Product product){

        product.setProductId(nexId++);

        products.add(product);
    }

    @Override
    public List<Product> getAll(){
        return products;
    }

}
