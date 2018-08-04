/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TOSHIBA
 */

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Product getById(long id){
        return productRepository.getOne(id);
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Product create(Product product){
        productRepository.save(product);
        return product;
    }
    
    public Product update(Product product){
        productRepository.save(product);
        return productRepository.getOne(product.getId());
    }
    
    public Product delete(long id){
        Product product = productRepository.getOne(id);
        productRepository.delete(product);
        return product;
    }
}
