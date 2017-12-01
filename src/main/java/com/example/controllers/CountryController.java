package com.example.controllers;

import com.example.controllers.helper.ResponseTransfer;
import com.example.controllers.helper.InstanceAlreadyExists;
import com.example.model.Country;
import com.example.repository.CountryRepository;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private CountryRepository CountryRepository;

    /**
     * Return all country presented in database
     *
     * @return
     */
    @GetMapping(value = "/all", headers = "Accept=application/json")
    public Iterable<Country> getAllCountries() {

        return CountryRepository.findAll();
    }

    /**
     * Add country to database
     *
     * @param countryName
     * @return
     */
    @PostMapping(value = "/add", headers = "Accept=application/json")
    public ResponseTransfer addNewCountry(@RequestBody String countryName) {

        Optional<Country> isExist = CountryRepository.findByCountryName(countryName);

        if (isExist.isPresent()) {
            logger.info("Country " + countryName + "is already exists!");
            throw new InstanceAlreadyExists("Country is already exists!");
        }

        Country country = new Country();
        country.setCountryName(countryName);
        CountryRepository.save(country);

        return new ResponseTransfer("Country successfully saved");
    }

    /**
     * Add country to the blacklist
     *
     * @param country
     * @return
     */
    @PostMapping(value = "/blacklist", headers = "Accept=application/json")
    public ResponseTransfer setUsersCountryToBlacklist(@RequestBody Country country) {

        CountryRepository.save(country);

        return new ResponseTransfer("Operation for Country " + country.getCountryName() + " has completed");
    }

    /***
     * Set loan limit for country in a given timeframe
     * @param country
     * @return 
     */
    @PostMapping(value = "/loanLimit", headers = "Accept=application/json")
    public ResponseTransfer setCountOfLoans(@RequestBody Country country) {

        CountryRepository.save(country);

        return new ResponseTransfer("Operation for Country " + country.getCountryName() + " has completed");
    }

}
