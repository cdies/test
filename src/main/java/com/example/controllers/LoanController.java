/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.model.Loan;
import com.example.repository.LoanRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {
    
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoanController.class);
    
    @Autowired
    LoanRepository loanRepository;

    @GetMapping(value = "/all", headers = "Accept=application/json")
    public Iterable<Loan> getAllUsers() {

        return loanRepository.findAll();
    }

}
