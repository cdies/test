/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.controllers.helper.ResponseTransfer;
import com.example.controllers.helper.InstanceAlreadyExists;
import com.example.model.Client;
import com.example.model.Loan;
import com.example.repository.ClientRepository;
import com.example.repository.LoanRepository;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {
    
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ClientController.class);
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private LoanRepository loanRepository;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseTransfer addNewCustomer(@RequestBody Client client) {
        
        Optional<Client> isExist = clientRepository.findByNameAndSurnameAndCountry(client.getName(), client.getSurname(), client.getCountry().getCountryName());
        
        if (isExist.isPresent()) {
            logger.info("Client " + client.getName() + ", " + client.getSurname() + " is already esists in DB!");
            throw new InstanceAlreadyExists("Client is already exists!");
        }
        
        clientRepository.save(client);
        
        return new ResponseTransfer("Client successfully saved.");
    }
    
    @GetMapping(value = "/all", headers = "Accept=application/json")
    public Iterable<Client> getAllUsers() {
        
        return clientRepository.findAll();
    }
    
    @RequestMapping(value = "/loan", method = RequestMethod.POST, headers = "Accept=application/json")
    public Iterable<Loan> GetAllLoansOfUsers(@RequestBody Long userId) {
        
        return loanRepository.findByUserId(userId);
    }
    
    @RequestMapping(value = "/add_blacklist", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseTransfer setUserToBlacklist(@RequestBody Long userId) {
        
        Client client = clientRepository.getOne(userId);
        client.setIsBlacklist(true);
        clientRepository.save(client);
        
        return new ResponseTransfer("Client added to blaclist");
    }
}
