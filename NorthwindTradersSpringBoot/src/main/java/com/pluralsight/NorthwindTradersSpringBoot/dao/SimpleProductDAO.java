package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO {
    private List<Product> products = new ArrayList<>();
    private int lastProductId = 3;

    public SimpleProductDAO() {
        products.add(new Product(1, "Coffee", 7));
        products.add(new Product(2, "Green tea", 3));
        products.add(new Product(3, "Smoothie", 7));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product add(Product product) {
       if (product.getProductId() == 0){
           product.setProductId(lastProductId + 1);
           lastProductId++;
       }
       products.add(product);
       return product;
    }
}
