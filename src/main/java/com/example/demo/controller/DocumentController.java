/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.DetailDocument;
import com.example.demo.model.Document;
import com.example.demo.model.Product;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.DocumentService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @RequestMapping(value = "/document", method = RequestMethod.GET)
    public List<Document> getAll() {
        return documentService.getAll();
    }

    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public Document getDocument(@PathVariable("id") long id) {
        return documentService.getById(id);
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public Document addDocument(@RequestBody Document document) {
        return documentService.create(document);
    }

    //Actually this has to be a logic deletion but.. later in a new fix
    @RequestMapping(value = "/document/{id}", method = RequestMethod.DELETE)
    public Document deleteDocument(@PathVariable("id") long id) {
        return documentService.delete(id);
    }

    @RequestMapping(value = "/document", method = RequestMethod.PUT)
    public Document updateDocument(@RequestBody Document document) {
        return documentService.update(document);
    }

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {

        //first we need prodcuts to sell
        
        Product productA = new Product("SkinCare", new BigDecimal(50.2));
        productRepository.save(productA);
        Product productB = new Product("SunBlock", new BigDecimal(15.5));
        productRepository.save(productB);
        
        //test
        Document document = new Document();
        document.setDate(new Date(1999, 2, 2));
        
        //firstsave 
        document = documentRepository.save(document);
       
        DetailDocument detaila = new DetailDocument();
        detaila.setProduct(productA);
        detaila.setCount(1);
        detaila.setSubtotal(detaila.getProduct().getPrice().multiply(new BigDecimal(detaila.getCount())));

        DetailDocument detailb = new DetailDocument();
        detailb.setProduct(productB);
        detailb.setCount(1);
        detailb.setSubtotal(detailb.getProduct().getPrice().multiply(new BigDecimal(detailb.getCount())));

        document.addDetailDocument(detaila);
        document.addDetailDocument(detailb);

        documentRepository.save(document);
    }
}
