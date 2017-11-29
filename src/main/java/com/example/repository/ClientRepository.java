/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.model.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Optional<Client> findById(Long id);
    
    Optional<Client> findByNameAndSurnameAndCountry(String name, String surname, String country);
    
    Iterable<Client> findByCountryCountryName(String countryName);
}
