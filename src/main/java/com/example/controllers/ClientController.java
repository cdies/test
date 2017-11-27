/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.model.Client;
import com.example.repository.ClientRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController    
public class ClientController {
    
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ClientController.class);
    
	@Autowired 
	private ClientRepository clientRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json") 
	public String addNewCustomer (@RequestBody Client client) {
                clientRepository.save(client);
                
		return "{ \"status\" : \"saved\"}";
	}

	@GetMapping(value = "/all", headers="Accept=application/json")
	public Iterable<Client> getAllUsers() {
		return clientRepository.findAll();
	}
}
