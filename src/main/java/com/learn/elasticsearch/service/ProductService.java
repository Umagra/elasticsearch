package com.learn.elasticsearch.service;

import com.learn.elasticsearch.entity.Product;
import com.learn.elasticsearch.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product insertProduct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(Product product, int id){
        Optional<Product> product1 = productRepo.findById(id);
        if(product1.isPresent()){
            Product p1 = product1.get();
            p1.setPrice(product.getPrice());
            p1.setDescription(product.getDescription());
            p1.setName(product.getName());
            p1.setQuantity(product.getQuantity());
            return p1;
        }else
            return null;

    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
}
