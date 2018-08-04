/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Document;
import com.example.demo.repository.DocumentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TOSHIBA
 */
@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    
    public Document getById(long id){
        return documentRepository.getOne(id);
    }
    
    public List<Document> getAll(){
        return documentRepository.findAll();
    }
    
    public Document create(Document document){
        documentRepository.save(document);
        return document;
    }
    
    public Document update(Document document){
        documentRepository.save(document);
        return document;
    }
    
    public Document delete(long id){
        Document doc = documentRepository.getOne(id);
        documentRepository.delete(doc);
        return doc;
    }
}
