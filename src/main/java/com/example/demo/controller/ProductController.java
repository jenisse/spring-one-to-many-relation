/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TOSHIBA
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> getAll() {
        return productService.getAll();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getById(id);
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product ) {
        return productService.create(product);
    }
    
    
    //Actually this has to be a logic deletion but.. later in a new fix
    @RequestMapping(value="/product/{id}", method = RequestMethod.DELETE)
    public Product deleteProduct(@PathVariable("id") long id){
        return productService.delete(id);
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product ) {
        return productService.update(product);
    }
}
