/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.simple.data;

import com.example.model.Client;
import com.example.model.Loan;
import com.example.repository.ClientRepository;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleData {

    @Autowired
    private ClientRepository clientRepository;

    @PostConstruct
    public void init() {
        Client client1 = new Client();
        client1.setName("Name1");
        client1.setSurname("Surname1");
        client1.setCountry("Country1");

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
        client2.setCountry("Country2");
        
        clientRepository.save(client2);
    }

}
