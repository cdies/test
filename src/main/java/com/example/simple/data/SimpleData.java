/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.simple.data;

import com.example.model.Client;
import com.example.model.Country;
import com.example.model.Loan;
import com.example.repository.ClientRepository;
import com.example.repository.CountryRepository;
import com.example.repository.LoanRepository;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleData {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void init() {

        Country country1 = new Country();
        country1.setCountryName("lv");
        countryRepository.save(country1);

        Country country2 = new Country();
        country2.setCountryName("pl");
        countryRepository.save(country2);

        Client client1 = new Client();
        client1.setName("Name1");
        client1.setSurname("Surname1");
        client1.setCountry(country1);

        Loan loan1 = new Loan();
        loan1.setLoan(111.0);
        loan1.setTerm("Simple term1");

        Loan loan2 = new Loan();
        loan2.setLoan(222.0);
        loan2.setTerm("Simple term2");

        client1.setLoans(Arrays.asList(loan1, loan2));

        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setName("Name2");
        client2.setSurname("Surname2");
        client2.setCountry(country1);

        clientRepository.save(client2);

        Loan loan3 = new Loan();
        loan3.setLoan(333.0);
        loan3.setTerm("Simple term3");
        loan3.setUserId(2L);

        loanRepository.save(loan3);

        Client client3 = new Client();
        client3.setName("Name3");
        client3.setSurname("Surname3");
        client3.setIsBlacklist(true);
        client3.setCountry(country2);

        clientRepository.save(client3);
    }
}
