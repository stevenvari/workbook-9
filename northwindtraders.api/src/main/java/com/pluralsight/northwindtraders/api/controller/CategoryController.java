package com.pluralsight.northwindtraders.api.controller;

import com.pluralsight.northwindtraders.api.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @GetMapping(path = "/categories")
    public List<Category> getAll(){

        List<Category> categories = new ArrayList<>();
        categories.add (new Category(1,"Electronic"));
        categories.add (new Category(2,"Clothing"));
        categories.add (new Category(3,"Beverages"));
        categories.add (new Category(4,"Reading"));
        categories.add (new Category(5,"Sports"));


        return categories;
    }
}
