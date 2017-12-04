/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.controllers.helper.ResponseTransfer;
import com.example.model.Country;
import com.example.model.Loan;
import com.example.model.Timeframe;
import com.example.repository.CountryRepository;
import com.example.repository.LoanRepository;
import com.example.repository.TimeframeRepository;
import java.util.Date;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private TimeframeRepository timeframeRepository;

    /**
     * Return all loans presented in database
     *
     * @return
     */
    @GetMapping(value = "/all", headers = "Accept=application/json")
    public Iterable<Loan> getAllLoans() {

        return loanRepository.findAll();
    }

    /**
     * Save loan in database
     *
     * @param loan
     * @return
     */
    @PostMapping(value = "/add", headers = "Accept=application/json")
    public ResponseTransfer saveLoan(@RequestBody Loan loan) {

        Date todayDate = new Date();

        Iterable<Timeframe> timeframes = timeframeRepository.findByCountryCode(loan.getCountryCode());

        if (timeframes != null) {
            for (Timeframe checkCountry : timeframes) {
                if (todayDate.after(checkCountry.getStartTime()) && todayDate.before(checkCountry.getEndTime())) {
                    if (checkCountry.getLoanCount() > checkCountry.getCurrentLoanCount()) {
                        checkCountry.setCurrentLoanCount(checkCountry.getCurrentLoanCount() + 1);
                        loanRepository.save(loan);
                        return new ResponseTransfer("Loan successefully added.");
                    } else {
                        return new ResponseTransfer("Current country has limit for a new loan.");
                    }
                }
            }
        }
        return new ResponseTransfer("Loan wasn't added.");
    }
}
