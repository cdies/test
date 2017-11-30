package com.example;

import com.example.model.Country;
import com.example.repository.ClientRepository;
import com.example.repository.CountryRepository;
import com.example.repository.LoanRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void contextLoads() {

        assertThat(clientRepository).isNotNull();
        assertThat(loanRepository).isNotNull();
        assertThat(countryRepository).isNotNull();
    }

    @Test
    public void testDataBase() {
        
        Country testCountry = new Country();
        testCountry.setCountryName("test");

        countryRepository.save(testCountry);
        
        assertThat(countryRepository.findByCountryName("test").isPresent()).isTrue();
        
        countryRepository.delete(testCountry);
        
        assertThat(countryRepository.findByCountryName("test").isPresent()).isFalse();
    }

}
