package com.learn.elasticsearch.controller;

import com.learn.elasticsearch.entity.Product;
import com.learn.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    Iterable<Product> findAll(){
        return productService.getProducts();
    }

    @PostMapping("/insert")
    Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

}
