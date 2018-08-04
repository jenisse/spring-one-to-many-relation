/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TOSHIBA
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    
    public Client getById(long id){
        return clientRepository.getOne(id);
    }
    
    public Client create(Client client){
        clientRepository.save(client);
        return client;
    }
    
    
    public Client update(Client client){
        clientRepository.save(client);
        return clientRepository.getOne(client.getId());
    }
    
    public Client delete(long id){
        Client client=clientRepository.getOne(id);
        clientRepository.delete(client);
        return client;
    }
    
}
