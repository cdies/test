/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.model.Timeframe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pc
 */
public interface TimeframeRepository extends JpaRepository<Timeframe, Long> {

    Iterable<Timeframe> findByCountryCode(String countryCode);
}
