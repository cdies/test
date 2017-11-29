/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.controllers.helper.ResponseTransfer;
import com.example.controllers.helper.InstanceAlreadyExists;
import com.example.model.Client;
import com.example.model.Country;
import com.example.repository.ClientRepository;
import com.example.repository.CountryRepository;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private CountryRepository CountryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/all", headers = "Accept=application/json")
    public Iterable<Country> getAllCountries() {

        return CountryRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseTransfer addNewCountry(@RequestBody String countryName) {

        Optional<Country> isExist = CountryRepository.findByCountryName(countryName);

        if (isExist.isPresent()) {
            logger.info("Country "+ countryName + "is already exists!");
            throw new InstanceAlreadyExists("Country is already exists!");
        }

        Country country = new Country();
        country.setCountryName(countryName);
        CountryRepository.save(country);

        return new ResponseTransfer("Country successfully saved");
    }

    @RequestMapping(value = "/add_blacklist", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseTransfer setUserToBlacklist(@RequestBody String countryName) {

        Iterable<Client> clients = clientRepository.findByCountryCountryName(countryName);

        for (Client client : clients) {
            client.setIsBlacklist(true);
            clientRepository.save(client);
        }

        return new ResponseTransfer("Client added to blaclist");
    }

}
