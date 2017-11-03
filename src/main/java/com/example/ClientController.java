/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public @ResponseBody String addNewCustomer (@RequestBody Client client) {

		ClientDB n = new ClientDB();
		n.setClient(client.getClient());
		n.setCity(client.getCity());
		clientRepository.save(n);
		return "{ \"status\" : \"saved\"}";
	}

	@GetMapping(value = "/all", headers="Accept=application/json")
	public @ResponseBody Iterable<ClientDB> getAllUsers() {
		return clientRepository.findAll();
	}
}
