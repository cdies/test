/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.controllers.helper.ResponseTransfer;
import com.example.model.Loan;
import com.example.repository.LoanRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping(value = "/all", headers = "Accept=application/json")
    public Iterable<Loan> getAllLoans() {

        return loanRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseTransfer saveLoan(@RequestBody Loan loan) {
        
        loanRepository.save(loan);
        
        return new ResponseTransfer("Loan successefully added.");
    }

}
