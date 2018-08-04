/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
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
public class ClientController {
    @Autowired
    ClientService clientService;
    
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable("id") long id) {
        return clientService.getById(id);
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public Client addClient(@RequestBody Client client ) {
        return clientService.create(client);
    }
    
    
    //Actually this has to be a logic deletion but.. later in a new fix
    @RequestMapping(value="/client/{id}", method = RequestMethod.DELETE)
    public Client deleteClient(@PathVariable("id") long id){
        return clientService.delete(id);
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public Client updateClient(@RequestBody Client client ) {
        return clientService.update(client);
    }
}
